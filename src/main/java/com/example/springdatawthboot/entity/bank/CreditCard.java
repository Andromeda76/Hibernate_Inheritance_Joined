package com.example.springdatawthboot.entity.bank;


import jakarta.persistence.*;
import jakarta.persistence.Table;
import org.hibernate.annotations.*;

import java.sql.Timestamp;



@Entity
@Table(name = "CreditCard")
public class CreditCard extends BillingDetail{

    @Column(name = "CardNumber", columnDefinition = "VARCHAR(100)", nullable = true)
    private String cardNumber;


    @Column(name = "expireDate", columnDefinition = "DateTime", nullable = false)
    @CreationTimestamp
    private Timestamp expDate;


    @AttributeOverride(
            name = "owner",
            column = @Column(name = "CreditAccountOwner", columnDefinition = "VARCHAR(100)", nullable = false))
    @Generated(GenerationTime.ALWAYS)
    private String creditAccountOwner;

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

    public String getCreditAccountOwner() {
        return creditAccountOwner;
    }

    public void setCreditAccountOwner(String creditAccountOwner) {
        this.creditAccountOwner = creditAccountOwner;
    }

}
