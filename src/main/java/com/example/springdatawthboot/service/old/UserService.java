package com.example.springdatawthboot.service.old;

import com.example.springdatawthboot.entity.old.User;
import com.example.springdatawthboot.facade.old.UserIRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {

    @Autowired
    UserIRepository repository;


    public User insertService(Long personId, String naturalCode){
        User user = new User(personId, naturalCode);

        repository.x();

        System.out.println(user.getId());
        return repository.save(user);
    }


}
