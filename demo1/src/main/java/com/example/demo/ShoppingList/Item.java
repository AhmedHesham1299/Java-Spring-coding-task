package com.example.demo.ShoppingList;

import jakarta.persistence.*;

@Entity
@Table(name = "ItemList")
public class Item {
    @Id
    @SequenceGenerator(
            name = "ItemList_sequence",
            sequenceName = "ItemList_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy =  GenerationType.SEQUENCE,
            generator = "ItemList_sequence"
    )
    private Integer itemid;
    private String name;
    private Integer ShoppingListID;
    private Integer quantity;




    public Item() {
    }

    public Item(Integer itemid, String name, Integer shoppingListID, Integer quantity) {
        this.itemid = itemid;
        this.name = name;
        ShoppingListID = shoppingListID;
        this.quantity = quantity;
    }

    public Item(String name, Integer shoppingListID, Integer quantity) {
        this.name = name;
        ShoppingListID = shoppingListID;
        this.quantity = quantity;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }

    public Integer getShoppingListID() {
        return ShoppingListID;
    }

    public void setShoppingListID(Integer shoppingListID) {
        ShoppingListID = shoppingListID;
    }

}
