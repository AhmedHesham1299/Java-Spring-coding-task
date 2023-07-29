package com.example.demo.ShoppingList;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;

@Data
@Entity
@Table(name = "ShoppingLists")
public class ShoppingList {
    @Id
    @SequenceGenerator(
            name = "ShoppingList_sequence",
            sequenceName = "ShoppingList_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy =  GenerationType.SEQUENCE,
            generator = "ShoppingList_sequence"
    )

    private Integer id;
    private String name;

    public ShoppingList() {
    }

    public ShoppingList(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public ShoppingList(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
