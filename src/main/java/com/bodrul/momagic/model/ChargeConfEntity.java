package com.bodrul.momagic.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "charge_conf", schema = "smsgw_demo", catalog = "")
public class ChargeConfEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "charge_code")
    private String chargeCode;
    @Basic
    @Column(name = "price")
    private int price;
    @Basic
    @Column(name = "price_with_vat")
    private double priceWithVat;
    @Basic
    @Column(name = "validity")
    private int validity;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getChargeCode() {
        return chargeCode;
    }

    public void setChargeCode(String chargeCode) {
        this.chargeCode = chargeCode;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public double getPriceWithVat() {
        return priceWithVat;
    }

    public void setPriceWithVat(double priceWithVat) {
        this.priceWithVat = priceWithVat;
    }

    public int getValidity() {
        return validity;
    }

    public void setValidity(int validity) {
        this.validity = validity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChargeConfEntity that = (ChargeConfEntity) o;
        return id == that.id && price == that.price && Double.compare(priceWithVat, that.priceWithVat) == 0 && validity == that.validity && Objects.equals(chargeCode, that.chargeCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, chargeCode, price, priceWithVat, validity);
    }
}
