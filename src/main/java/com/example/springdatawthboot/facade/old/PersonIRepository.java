package com.example.springdatawthboot.facade.old;

import java.util.List;

import com.example.springdatawthboot.entity.old.Person;
import jakarta.validation.constraints.Size;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.util.Streamable;
import org.springframework.transaction.annotation.Transactional;


public interface PersonIRepository extends SamaneIRepository<Person, Integer> {

    List<Person> getPersonByFamilyOrName(String family, @Size(
            min = 2,
            max = 255,
            message = "Name is required, maximum 255 characters."
    ) String name);

    List<Person> findTopByIdIn(List<Long> list);

    Streamable<Person> findAllByFamilyContaining(String family);


    @Modifying
    @Transactional
    @Query("update Person p set p.address.street = :street, p.address.zipCode = :zipcode where p.family = :family")
    void updateAllPerson(@Param("street") String street,
                         @Param("zipcode") String zipcode,
                         @Param("family") String family);


    @Query(value = "select count(p) from Person p where p.name like %:name%")
    Integer personNumber (@Param("name") String name);

    List<Person.Projection> findByNameContaining(String name);

    @Modifying
    @Transactional
    @Query(value = "update Person p set p.name = :name where p.rc = 0")
    void updatePerson(@Param("name") String name);

    List<Person> findByRc(int rc, Sort name);

     List<Person> findAll();


}

