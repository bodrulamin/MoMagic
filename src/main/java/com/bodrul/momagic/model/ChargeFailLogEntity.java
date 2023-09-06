package com.bodrul.momagic.model;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "charge_fail_log", schema = "smsgw_demo", catalog = "")
public class ChargeFailLogEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private long id;
    @Basic
    @Column(name = "sms_id")
    private long smsId;
    @Basic
    @Column(name = "msisdn")
    private String msisdn;
    @Basic
    @Column(name = "keyword_id")
    private int keywordId;
    @Basic
    @Column(name = "amount")
    private int amount;
    @Basic
    @Column(name = "charge_id")
    private int chargeId;
    @Basic
    @Column(name = "fail_code")
    private int failCode;
    @Basic
    @Column(name = "ins_date")
    private Timestamp insDate;
    @Basic
    @Column(name = "tid_ref")
    private String tidRef;
    @Basic
    @Column(name = "response")
    private String response;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getSmsId() {
        return smsId;
    }

    public void setSmsId(long smsId) {
        this.smsId = smsId;
    }

    public String getMsisdn() {
        return msisdn;
    }

    public void setMsisdn(String msisdn) {
        this.msisdn = msisdn;
    }

    public int getKeywordId() {
        return keywordId;
    }

    public void setKeywordId(int keywordId) {
        this.keywordId = keywordId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getChargeId() {
        return chargeId;
    }

    public void setChargeId(int chargeId) {
        this.chargeId = chargeId;
    }

    public int getFailCode() {
        return failCode;
    }

    public void setFailCode(int failCode) {
        this.failCode = failCode;
    }

    public Timestamp getInsDate() {
        return insDate;
    }

    public void setInsDate(Timestamp insDate) {
        this.insDate = insDate;
    }

    public String getTidRef() {
        return tidRef;
    }

    public void setTidRef(String tidRef) {
        this.tidRef = tidRef;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChargeFailLogEntity that = (ChargeFailLogEntity) o;
        return id == that.id && smsId == that.smsId && keywordId == that.keywordId && amount == that.amount && chargeId == that.chargeId && failCode == that.failCode && Objects.equals(msisdn, that.msisdn) && Objects.equals(insDate, that.insDate) && Objects.equals(tidRef, that.tidRef) && Objects.equals(response, that.response);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, smsId, msisdn, keywordId, amount, chargeId, failCode, insDate, tidRef, response);
    }
}
