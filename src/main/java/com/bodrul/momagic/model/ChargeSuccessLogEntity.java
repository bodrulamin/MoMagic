package com.bodrul.momagic.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.Accessors;

import java.sql.Timestamp;

@Builder
@Getter
@Setter
@RequiredArgsConstructor
@Accessors(chain = true)
@Entity
@Table(name = "charge_success_log", schema = "smsgw_demo", catalog = "")
@AllArgsConstructor
public class ChargeSuccessLogEntity {
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
    @Column(name = "amount_with_vat")
    private double amountWithVat;
    @Basic
    @Column(name = "validity")
    private int validity;
    @Basic
    @Column(name = "charge_id")
    private int chargeId;
    @Basic
    @Column(name = "ins_date")
    private Timestamp insDate;
    @Basic
    @Column(name = "tid_ref")
    private String tidRef;
    @Basic
    @Column(name = "response")
    private String response;

}
