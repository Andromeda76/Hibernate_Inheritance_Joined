package com.example.springdatawthboot.entity.old;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class Address {

    @Column(nullable = true)
    private String street;

    @Column(nullable = true)
    private String zipCode;


    public Address(String street, String number) {
        this.street = street;
        this.zipCode = number;
    }

    public Address() {
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String number) {
        this.zipCode = number;
    }

}


