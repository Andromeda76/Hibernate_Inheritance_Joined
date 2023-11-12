package com.example.springdatawthboot.entity.bank;


import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;


@Entity
@Table(name = "CreditCard")
@SecondaryTable(name = "CreditCard",
                pkJoinColumns = @PrimaryKeyJoinColumn(name = "id"))
public class CreditCard extends BillingDetail{

    @Column(table = "CreditCard",name = "CardNumber", columnDefinition = "VARCHAR(100)", nullable = true)
    private String cardNumber;

    @CreationTimestamp
    @Column(table = "CreditCard", name = "expireDate", columnDefinition = "DateTime", nullable = false)
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
