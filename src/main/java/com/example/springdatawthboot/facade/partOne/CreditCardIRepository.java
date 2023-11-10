package com.example.springdatawthboot.facade.partOne;

import java.util.List;
import com.example.springdatawthboot.entity.bank.CreditCard;


public interface CreditCardIRepository extends BankDetailIRepository<CreditCard, Long> {

    List<CreditCard> findAllByCardNumber(String cardNumber);

}
