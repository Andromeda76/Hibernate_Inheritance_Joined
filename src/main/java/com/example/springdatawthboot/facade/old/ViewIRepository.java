package com.example.springdatawthboot.facade.old;

import com.example.springdatawthboot.entity.view.UserView;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ViewIRepository extends JpaRepository<UserView, Long> {
}
