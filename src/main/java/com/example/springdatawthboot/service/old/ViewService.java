package com.example.springdatawthboot.service.old;


import com.example.springdatawthboot.entity.view.UserView;
import com.example.springdatawthboot.facade.old.ViewIRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ViewService extends AddressService{

    @Autowired
    ViewIRepository repository;


    public List<UserView> views(){
        return repository.findAll();
    }

}
