package com.example.springdatawthboot.entity.old;

import com.example.springdatawthboot.entity.Test.Week;
import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import org.hibernate.annotations.*;

import java.io.Serializable;


@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "BusinessUser")
public class User implements Serializable {

    @Id
    @GeneratedValue(generator = "sequenceGenerator")
    @GenericGenerator(name = "sequenceGenerator",
            strategy = "enhanced-sequence",
            parameters = {
            @org.hibernate.annotations.Parameter(
                    name = "sequence_name",
                    value = "User_seq"
            ),
            @org.hibernate.annotations.Parameter(
                    name = "initial_value",
                    value = "100"
            ),
            @org.hibernate.annotations.Parameter(
                    name = "increment_size",
                    value = "1"
            )})
    private Long id;

    @Column(name = "NaturalCode")
    private String naturalCode;

    @Column(name = "PersonId")
    private Long personId;

    @Column(name = "Ids")
    @ColumnTransformer(
            read = "Id / 2",
            write = "? * 654"
    )
    private double averageIds;


    public User(Long personId, String naturalCode){
        this.naturalCode = naturalCode;
        this.personId = personId;
    }

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNaturalCode() {
        return naturalCode;
    }

    public void setNaturalCode(String naturalCode) {
        this.naturalCode = naturalCode;
    }

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    public double getAverageIds() {
        return averageIds;
    }

    public void setAverageIds(double averageIds) {
        this.averageIds = averageIds;
    }

}
