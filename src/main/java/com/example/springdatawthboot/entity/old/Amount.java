package com.example.springdatawthboot.entity.old;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "Amount")
public class Amount implements Serializable {

    @Id
    @GeneratedValue(generator = "sequence-generator")
    @GenericGenerator(name = "sequence-generator",
            strategy = "enhanced-sequence",
            parameters = {
                    @Parameter(
                            name = "sequence_name",
                            value = "Amount_seq"
                    ),
                    @Parameter(
                            name = "initial_value",
                            value = "1"
                    ),
                    @Parameter(
                            name = "increment_size",
                            value = "1"
                    )})
    private Long id;

    @Column(name = "Currency", columnDefinition = "Decimal", nullable = true)
    private BigDecimal currency;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getCurrency() {
        return currency;
    }

    public void setCurrency(BigDecimal currency) {
        this.currency = currency;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return super.toString();
    }

}


