package com.example.springdatawthboot.service.partOne;


import java.util.List;

import com.example.springdatawthboot.entity.bank.BankAccount;
import com.example.springdatawthboot.facade.partOne.BankAccountRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;



@Service
public class BankAccountService {

    private final BankAccountRepository repository;

    public BankAccountService(@Qualifier("bankAccountRepository")
                              BankAccountRepository repository){
        this.repository = repository;
    }


    public BankAccount insert(BankAccount bankAccount){
        return repository.save(bankAccount);
    }

    public List<BankAccount> bankAccounts(String name){
        return repository.findByOwner(name);
    }

}
