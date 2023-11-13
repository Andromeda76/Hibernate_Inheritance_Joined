package com.example.springdatawthboot.entity.dimension;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "Item")
public class Item {
    @Id
    @GenericGenerator(name = "sequence_generator",
            strategy = "enhanced-sequence",
        parameters = {
            @Parameter(
                    name = "sequence_name",
                    value = "Item_SEQ_Generator"
            ),
            @Parameter(
                    name = "initial_value",
                    value = "1"
            ),
             @Parameter(
                    name = "increment_size",
                    value = "5"
               )})
    @GeneratedValue(generator = "sequence_generator")
    private Long id;

    private Dimensions dimensions;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Dimensions getDimensions() {
        return dimensions;
    }

    public void setDimensions(Dimensions dimensions) {
        this.dimensions = dimensions;
    }

}
