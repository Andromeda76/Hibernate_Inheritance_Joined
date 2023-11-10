package com.example.springdatawthboot.entity.bank;


import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;


/**
 * In making inheritance with @Inheritance(strategy = InheritanceType.TABLE_PER_CLASS) we do not have class
 * annotated by @Inheritance(strategy = InheritanceType.TABLE_PER_CLASS), those classes which inherited from
 * this class will inherit properties from this class exactly with name that is used in super class,
 * @AttributeOverride does not replace column value from superclass to annotated one,
 */

//@MappedSuperclass
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
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


//    @Column(name = "Owner", columnDefinition = "VARCHAR(100)")
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
