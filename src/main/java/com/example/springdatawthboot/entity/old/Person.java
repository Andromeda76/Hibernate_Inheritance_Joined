package com.example.springdatawthboot.entity.old;


import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;

import java.io.Serializable;
import java.util.Objects;


@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "Person")
public class Person implements Serializable {

    @Id
//    @SequenceGenerator(name = "ps", sequenceName = "person_seq", allocationSize = 1)
//    @GeneratedValue(strategy = GenerationType.AUTO, generator = "ps")
    @GeneratedValue(generator = "sequence-generator")
    @GenericGenerator(name = "sequence-generator",
            strategy = "enhanced-sequence",
            parameters = {
                    @org.hibernate.annotations.Parameter(
                            name = "sequence_name",
                            value = "Person_seq"
                    ),
                    @org.hibernate.annotations.Parameter(
                            name = "initial_value",
                            value = "4"
                    ),
                    @org.hibernate.annotations.Parameter(
                            name = "increment_size",
                            value = "1"
                    )
                    /**
                     * we've also set an initial value for the sequence, which means
                     * the primary key generation will start at 4.
                     */
            })
    private Long id;


    @Column(name = "Name", columnDefinition = "VARCHAR(20)", nullable = false)
    @Size(
            min = 2,
            max = 255,
            message = "Name is required, maximum 255 characters."
    )
    private String name;

    @Column(name = "Family", columnDefinition = "VARCHAR(20)")
    private String family;


    @Embedded
    @AttributeOverride(name = "street",
            column = @Column(name = "Street"))
    @AttributeOverride(name = "zipCode",
            column = @Column(name = "ZipCode"))
    private Address address;

    @Version
    private int rc;


    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Person(String name, String family, Address address) {
        this.name = name;
        this.family = family;
        this.address = address;
    }

    public Person(Long id, String name, String family) {
        this.id = id;
        this.name = name;
        this.family = family;
    }

    public Person(Long id){
        this.id = id;
    }

    public Person() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public int getRc() {
        return rc;
    }

    public void setRc(int rc) {
        this.rc = rc;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return rc == person.rc && Objects.equals(id, person.id) && Objects.equals(name, person.name)
                && Objects.equals(family, person.family) && Objects.equals(address, person.address);
    }


    @Override
    public int hashCode() {
        return Objects.hash(id, name, family, address, rc);
    }


    public static class Projection{
        private String family;

        public Projection(String family){
            this.family = family;
        }

        public String getFamily() {
            return family;
        }
    }


}
