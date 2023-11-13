package com.example.springdatawthboot.facade.partOne;

import com.example.springdatawthboot.entity.dimension.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemIRepository extends JpaRepository<Item, Long> {
}
