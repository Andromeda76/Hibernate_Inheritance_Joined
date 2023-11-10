package com.example.springdatawthboot.service.partOne;


import com.example.springdatawthboot.entity.bank.BankAccount;
import com.example.springdatawthboot.facade.partOne.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BankAccountService {

    @Autowired
    @Qualifier("bankAccountRepository")
    BankAccountRepository repository;


    public BankAccount insert(BankAccount bankAccount){
        return repository.save(bankAccount);
    }

    public List<BankAccount> bankAccounts(String name){
        return repository.findByOwner(name);
    }

}
