package com.example.springdatawthboot.entity.view;

import jakarta.persistence.*;
import org.hibernate.annotations.*;


@Entity
@Immutable
@Subselect("select p.Id as viewId, p.Name as name, p.Family as family, u.NaturalCode as uniqueCode " +
        "from Person p left outer join BusinessUser u on p.Id = u.PersonId")
@Synchronize({"Person", "BusinessUser"})
public class UserView {

    @Id
    private Long viewId;

    @Access(AccessType.FIELD)
    private String name;

    @Access(AccessType.PROPERTY)
    private String family;

    @Access(AccessType.PROPERTY)
    private String uniqueCode;


    @Formula("(select count(*) from Person)")
    private Integer summing;



    public Long getViewId() {
        return viewId;
    }

    public void setViewId(Long viewId) {
        this.viewId = viewId;
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

    public String getUniqueCode() {
        return uniqueCode;
    }

    public void setUniqueCode(String uniqueCode) {
        this.uniqueCode = uniqueCode;
    }

    public Integer getSumming() {
        return summing;
    }

    public void setSumming(Integer summing) {
        this.summing = summing;
    }

}
