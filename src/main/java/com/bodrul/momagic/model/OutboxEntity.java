package com.bodrul.momagic.model;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "outbox", schema = "smsgw_demo", catalog = "")
public class OutboxEntity {
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
    @Column(name = "ins_date")
    private Timestamp insDate;
    @Basic
    @Column(name = "sms_text")
    private String smsText;
    @Basic
    @Column(name = "reply_addr")
    private String replyAddr;
    @Basic
    @Column(name = "status")
    private String status;
    @Basic
    @Column(name = "send_date")
    private Timestamp sendDate;

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

    public String getReplyAddr() {
        return replyAddr;
    }

    public void setReplyAddr(String replyAddr) {
        this.replyAddr = replyAddr;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Timestamp getSendDate() {
        return sendDate;
    }

    public void setSendDate(Timestamp sendDate) {
        this.sendDate = sendDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OutboxEntity that = (OutboxEntity) o;
        return id == that.id && smsId == that.smsId && Objects.equals(msisdn, that.msisdn) && Objects.equals(insDate, that.insDate) && Objects.equals(smsText, that.smsText) && Objects.equals(replyAddr, that.replyAddr) && Objects.equals(status, that.status) && Objects.equals(sendDate, that.sendDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, smsId, msisdn, insDate, smsText, replyAddr, status, sendDate);
    }
}
