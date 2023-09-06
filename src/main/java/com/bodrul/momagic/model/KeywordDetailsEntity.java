package com.bodrul.momagic.model;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "keyword_details", schema = "smsgw_demo", catalog = "")
public class KeywordDetailsEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "keyword")
    private String keyword;
    @Basic
    @Column(name = "game_name")
    private String gameName;
    @Basic
    @Column(name = "sms_spliter")
    private String smsSpliter;
    @Basic
    @Column(name = "unlockurl")
    private String unlockurl;
    @Basic
    @Column(name = "unlockurl_response_splitter")
    private String unlockurlResponseSplitter;
    @Basic
    @Column(name = "unlock_sms")
    private String unlockSms;
    @Basic
    @Column(name = "chargeurl")
    private String chargeurl;
    @Basic
    @Column(name = "ins_date")
    private Timestamp insDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public String getSmsSpliter() {
        return smsSpliter;
    }

    public void setSmsSpliter(String smsSpliter) {
        this.smsSpliter = smsSpliter;
    }

    public String getUnlockurl() {
        return unlockurl;
    }

    public void setUnlockurl(String unlockurl) {
        this.unlockurl = unlockurl;
    }

    public String getUnlockurlResponseSplitter() {
        return unlockurlResponseSplitter;
    }

    public void setUnlockurlResponseSplitter(String unlockurlResponseSplitter) {
        this.unlockurlResponseSplitter = unlockurlResponseSplitter;
    }

    public String getUnlockSms() {
        return unlockSms;
    }

    public void setUnlockSms(String unlockSms) {
        this.unlockSms = unlockSms;
    }

    public String getChargeurl() {
        return chargeurl;
    }

    public void setChargeurl(String chargeurl) {
        this.chargeurl = chargeurl;
    }

    public Timestamp getInsDate() {
        return insDate;
    }

    public void setInsDate(Timestamp insDate) {
        this.insDate = insDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        KeywordDetailsEntity that = (KeywordDetailsEntity) o;
        return id == that.id && Objects.equals(keyword, that.keyword) && Objects.equals(gameName, that.gameName) && Objects.equals(smsSpliter, that.smsSpliter) && Objects.equals(unlockurl, that.unlockurl) && Objects.equals(unlockurlResponseSplitter, that.unlockurlResponseSplitter) && Objects.equals(unlockSms, that.unlockSms) && Objects.equals(chargeurl, that.chargeurl) && Objects.equals(insDate, that.insDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, keyword, gameName, smsSpliter, unlockurl, unlockurlResponseSplitter, unlockSms, chargeurl, insDate);
    }
}
