package com.example.springdatawthboot.facade.partOne;

import java.util.List;

import com.example.springdatawthboot.entity.bank.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BankAccountRepository extends BankDetailIRepository<BankAccount, Long> {



}
