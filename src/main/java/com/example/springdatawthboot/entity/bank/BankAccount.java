package com.example.springdatawthboot.entity.bank;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;


@Entity
@Table(name = "BankAccount")
public class BankAccount extends BillingDetail{

    @Column(name = "Account", columnDefinition = "VARCHAR(100)", nullable = true)
    private String account;

    @Column(name = "BankName", columnDefinition = "VARCHAR(100)", nullable = true)
    private String bankName;


    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

}
