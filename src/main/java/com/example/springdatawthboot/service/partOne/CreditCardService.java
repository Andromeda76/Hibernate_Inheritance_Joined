package com.example.springdatawthboot.service.partOne;

import java.util.List;

import com.example.springdatawthboot.entity.bank.CreditCard;
import com.example.springdatawthboot.facade.partOne.CreditCardIRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


@Service
public class CreditCardService {

    @Autowired
    @Qualifier("creditCardIRepository")
    CreditCardIRepository repository;


    public List<CreditCard> creditCards(String cardNumber){
        return repository.findAllByCardNumber(cardNumber);
    }

    public CreditCard save(CreditCard creditCard){
        return repository.save(creditCard);
    }

    public List<CreditCard> findByOwner(String name){
        return repository.findByOwner(name);
    }


}
