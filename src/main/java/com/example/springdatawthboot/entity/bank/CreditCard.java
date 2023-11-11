package com.example.springdatawthboot.entity.bank;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;


@Entity
@Table(name = "CreditCard")
@PrimaryKeyJoinColumn(name = "ID")
public class CreditCard extends BillingDetail{

    @Column(name = "CardNumber", columnDefinition = "VARCHAR(100)", nullable = true)
    private String cardNumber;


    @Column(name = "expireDate", columnDefinition = "DateTime", nullable = false)
    @CreationTimestamp
    private Timestamp expDate;


    public CreditCard() {
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public Timestamp getExpDate() {
        return expDate;
    }

    public void setExpDate(Timestamp expDate) {
        this.expDate = expDate;
    }

}
