package com.example.springdatawthboot.facade.old;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;


@NoRepositoryBean
public interface SamaneIRepository<T, U> extends JpaRepository<T, U> {

    default void x(){}



}
