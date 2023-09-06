package com.bodrul.momagic.model;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "inbox", schema = "smsgw_demo", catalog = "")
public class InboxEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private long id;
    @Basic
    @Column(name = "msisdn")
    private String msisdn;
    @Basic
    @Column(name = "ins_date")
    private Timestamp insDate;
    @Basic
    @Column(name = "sms_text")
    private String smsText;
    @Basic
    @Column(name = "status")
    private String status;
    @Basic
    @Column(name = "pro_date")
    private Timestamp proDate;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMsisdn() {
        return msisdn;
    }

    public void setMsisdn(String msisdn) {
        this.msisdn = msisdn;
    }

    public Timestamp getInsDate() {
        return insDate;
    }

    public void setInsDate(Timestamp insDate) {
        this.insDate = insDate;
    }

    public String getSmsText() {
        return smsText;
    }

    public void setSmsText(String smsText) {
        this.smsText = smsText;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Timestamp getProDate() {
        return proDate;
    }

    public void setProDate(Timestamp proDate) {
        this.proDate = proDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InboxEntity that = (InboxEntity) o;
        return id == that.id && Objects.equals(msisdn, that.msisdn) && Objects.equals(insDate, that.insDate) && Objects.equals(smsText, that.smsText) && Objects.equals(status, that.status) && Objects.equals(proDate, that.proDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, msisdn, insDate, smsText, status, proDate);
    }
}
