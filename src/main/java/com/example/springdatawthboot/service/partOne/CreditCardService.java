package com.example.springdatawthboot.service.partOne;


import com.example.springdatawthboot.entity.bank.CreditCard;
import com.example.springdatawthboot.facade.partOne.CreditCardIRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CreditCardService {

    private final CreditCardIRepository repository;

    public CreditCardService(@Qualifier("creditCardIRepository")
                             CreditCardIRepository repository){
        this.repository = repository;
    }

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
