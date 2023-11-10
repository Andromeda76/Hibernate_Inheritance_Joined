package com.example.springdatawthboot.facade.partOne;


import java.util.List;

import com.example.springdatawthboot.entity.bank.BillingDetail;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * When we use @NoRepositoryBean that we have abstract class with no directly persistence,
 * it means that in superEntityClass we have @MappedSuperclass annotation with no @Entity
 * this means that we have abstract class that other classes extends from it and overrides
 * its columns as attributes inside itself
 * @param <T>
 * @param <ID>
 */

//@NoRepositoryBean
public interface BankDetailIRepository<T extends BillingDetail, ID> extends JpaRepository<T, ID> {
    List<T> findByOwner(String owner);
}
