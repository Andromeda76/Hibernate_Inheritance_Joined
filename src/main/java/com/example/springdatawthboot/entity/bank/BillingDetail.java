package com.example.springdatawthboot.entity.bank;


import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;


/**
 * In @Inheritance(strategy = InheritanceType.SINGLE_TABLE) all extended classes column will be summarized in
 * a table then it is not needed to have union all (like Inheritance.Table_Per_Class) in backGround query
 * or any join fetch to boost query speed, but there is a problem that there is no insert or delete from
 * subclasses and all of them will be inserted to superClass annotated by
 * @Inheritance(strategy = InheritanceType.SINGLE_TABLE); this table makes
 * difference between data belong to other table with @DiscriminatorColumn
 */

//@MappedSuperclass
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn
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
