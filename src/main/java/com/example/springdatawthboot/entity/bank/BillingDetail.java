package com.example.springdatawthboot.entity.bank;


import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;


/**
 * if you use MappedSuperclass alone it does not polymorphism in inheritance.
 */

//@MappedSuperclass
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class BillingDetail {
    @Id
    @GenericGenerator(name = "sequence_generator",
                strategy = "enhanced-sequence",
            parameters = {
            @Parameter(
                    name = "sequence_name",
                    value = "BillingDetail_SEQ"
            ),
            @Parameter(
                    name = "initial_value",
                    value = "1"
            ),
            @Parameter(
                    name = "increment_size",
                    value = "1"
            )})
    @GeneratedValue(generator = "sequence_generator")
    private Long id;


    @Column(name = "Owner", columnDefinition = "VARCHAR(100)")
    @Size(
            min = 2,
            max = 100,
            message = "accountOwner"
    )
//    @Generated(GenerationTime.ALWAYS)
    private String owner;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

}
