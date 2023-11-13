package com.example.springdatawthboot.entity.dimension;


import jakarta.persistence.Basic;
import jakarta.persistence.MappedSuperclass;


@MappedSuperclass
public abstract class Measure {

    @Basic
    private String name;

    @Basic
    private String symbol;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

}
