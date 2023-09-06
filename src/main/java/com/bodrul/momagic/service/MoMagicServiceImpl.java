package com.bodrul.momagic.service;

import com.bodrul.momagic.model.AppConfEntity;
import com.bodrul.momagic.repository.AppConfEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MoMagicServiceImpl {

    @Autowired
    AppConfEntityRepository appConfEntityRepository;

    @EventListener({ApplicationReadyEvent.class})
    public void runThis(){
        System.out.println("Momagic Application Started !");
        List<AppConfEntity> all = appConfEntityRepository.findAll();
        all.forEach(e->{
            System.out.println(e.getAppName());
        });
    }
}
