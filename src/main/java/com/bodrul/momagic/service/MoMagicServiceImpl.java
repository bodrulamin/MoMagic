package com.bodrul.momagic.service;

import com.bodrul.momagic.model.*;
import com.bodrul.momagic.repository.*;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class MoMagicServiceImpl {

    final AppConfEntityRepository appConfEntityRepository;
    final InboxEntityRepository inboxEntityRepository;
    final ChargeConfEntityRepository chargeConfEntityRepository;
    final KeywordDetailsEntityRepository keywordDetailsEntityRepository;
    final ChargeFailLogEntityRepository chargeFailLogEntityRepository;
    final ChargeSuccessLogEntityRepository chargeSuccessLogEntityRepository;
    private Optional<AppConfEntity> config;

    public MoMagicServiceImpl(AppConfEntityRepository appConfEntityRepository, InboxEntityRepository inboxEntityRepository, ChargeConfEntityRepository chargeConfEntityRepository, KeywordDetailsEntityRepository keywordDetailsEntityRepository, ChargeFailLogEntityRepository chargeFailLogEntityRepository, ChargeSuccessLogEntityRepository chargeSuccessLogEntityRepository) {
        this.appConfEntityRepository = appConfEntityRepository;
        this.inboxEntityRepository = inboxEntityRepository;
        this.chargeConfEntityRepository = chargeConfEntityRepository;
        this.keywordDetailsEntityRepository = keywordDetailsEntityRepository;
        this.chargeFailLogEntityRepository = chargeFailLogEntityRepository;
        this.chargeSuccessLogEntityRepository = chargeSuccessLogEntityRepository;
    }

    @Scheduled(fixedDelay = 1)
    public void runThis() {
        while (true) {
            checkAppConfigStatus();

            Pageable pageable = PageRequest.of(0,config.get().getNumberOfRow());
            List<InboxEntity> inboxList = inboxEntityRepository.findByStatusOrderById("N", pageable);

            if (!inboxList.isEmpty()){
                inboxList.forEach(inbox -> {
                    checkAppConfigStatus();
                    String smsText = inbox.getSmsText();
                    String keyword = smsText.split(" ")[0];

                    Optional<KeywordDetailsEntity> keywordDetails = keywordDetailsEntityRepository.findByKeyword(keyword);
                   if (keywordDetails.isPresent()){

                       String unlockUrlPattern = keywordDetails.get().getUnlockurl();
                       String chargeUrlPattern = keywordDetails.get().getChargeurl();

                       String unlockUrl = unlockUrlPattern.replace("<sms_text>", inbox.getSmsText());
                       String unlockCode = "";
                       String charge = "";
                       try {
                           String response = RestClient.getResponse(unlockUrl);
                           unlockCode = response.split("::")[0];
                           charge = response.split("::")[1];
                       } catch (Exception e) {
                           throw new RuntimeException(e);
                       }

                       if (unlockCode ==null || unlockCode.isEmpty()){
                           return;
                       }
                       Optional<ChargeConfEntity> chargeConfig = chargeConfEntityRepository.findByPrice(Integer.parseInt(charge));

                       if (chargeConfig.isPresent()){
                           String chargeCode = chargeConfig.get().getChargeCode();

                           String chargeUrl = chargeUrlPattern.replace("<charge_code>", chargeCode).replace("<msisdn>",inbox.getMsisdn());

                           try {
                               String response = RestClient.getResponse(chargeUrl);
                               String[] responses = response.split("::");
                               String txn = responses[0];
                               String responseCode = responses[1];
                               String responseMsg = responses[2];
                               switch (responseCode){
                                   case "100" -> processSuccess(inbox,responses,chargeConfig,keywordDetails);
                                   default -> processFailed(inbox,responses,chargeConfig,keywordDetails);
                               }
                           } catch (Exception e) {
                               throw new RuntimeException(e);
                           }
                       }

                   }
                });
            }

        }

    }

    private void checkAppConfigStatus() {
        config = appConfEntityRepository.findById(1);
        if (config.isEmpty() || config.get().getStatus() == 0){
            System.out.println("AppConfig Status 0, Exiting app...");
            System.exit(1);
        }
    }

    private void processSuccess(InboxEntity inbox, String[] responses, Optional<ChargeConfEntity> chargeConfig, Optional<KeywordDetailsEntity> keywordDetails) {

        inbox.setStatus("S");
        inboxEntityRepository.save(inbox);
        ChargeSuccessLogEntity ce = new ChargeSuccessLogEntity()
                .setSmsId(inbox.getId())
                .setMsisdn(inbox.getMsisdn())
                .setKeywordId(keywordDetails.get().getId())
                .setAmount(chargeConfig.get().getPrice())
                .setAmountWithVat(chargeConfig.get().getPriceWithVat())
                .setValidity(chargeConfig.get().getValidity())
                .setChargeId(chargeConfig.get().getId())
                .setInsDate(Timestamp.valueOf(LocalDateTime.now()))
                .setTidRef(responses[0])
                .setResponse(responses[2]);
        System.out.println("Success: " + inbox.getId()+ " "+ inbox.getSmsText());

        chargeSuccessLogEntityRepository.save(ce);
    }


    private void processFailed(InboxEntity inbox, String[] responses, Optional<ChargeConfEntity> chargeConfig, Optional<KeywordDetailsEntity> keywordDetails) {
        inbox.setStatus("F");
        inboxEntityRepository.save(inbox);
        ChargeFailLogEntity ce = new ChargeFailLogEntity()
                .setSmsId(inbox.getId())
                .setMsisdn(inbox.getMsisdn())
                .setKeywordId(keywordDetails.get().getId())
                .setAmount(chargeConfig.get().getPrice())
                .setChargeId(chargeConfig.get().getId())
                .setFailCode(Integer.parseInt(responses[1]))
                .setInsDate(Timestamp.valueOf(LocalDateTime.now()))
                .setTidRef(responses[0])
                .setResponse(responses[2]);
        chargeFailLogEntityRepository.save(ce);
        System.out.println("Failed: " + inbox.getId()+ " "+ inbox.getSmsText());

    }


}
