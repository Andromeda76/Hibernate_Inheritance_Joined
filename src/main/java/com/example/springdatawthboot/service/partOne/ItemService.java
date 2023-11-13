package com.example.springdatawthboot.service.partOne;

import com.example.springdatawthboot.entity.dimension.Item;
import com.example.springdatawthboot.facade.partOne.ItemIRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


@Service
public class ItemService {


    private final ItemIRepository itemIRepository;

    public ItemService(@Qualifier("itemIRepository")
                       ItemIRepository itemIRepository){
        this.itemIRepository = itemIRepository;
    }

    public Item saveItem(Item item){
        return itemIRepository.save(item);
    }

}
