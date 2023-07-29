package com.example.demo.ShoppingList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "endpoint/shopping-lists")
public class ShoppingListController {
    private final ShoppingListService shoppinglistservice;
    @Autowired
    public ShoppingListController(ShoppingListService shoppinglistservice) {
        this.shoppinglistservice = shoppinglistservice;
    }

    @GetMapping
    public List<ShoppingList> GetShoppingLists(){
        return shoppinglistservice.GetShoppingLists();
    }

    @PostMapping
    public void newShoppingList(@RequestBody ShoppingList shoppingList){
        shoppinglistservice.addNewList(shoppingList);
    }
    @GetMapping(path = "{id}")
    public ShoppingList GetShoppingList(@PathVariable("id") Integer id){
        return shoppinglistservice.GetShoppingList(id);
    }

    @PutMapping(path = "{id}")
    public void updateShoppingList(
        @PathVariable("id") Integer id,
        @RequestParam(required = false) String name){
        shoppinglistservice.updateShoppingList(id, name);
    }

    @DeleteMapping(path = "{id}")
    public void DeleteShoppingList(@PathVariable("id") Integer id){
         shoppinglistservice.DeleteShoppingList(id);
    }

    @PostMapping(path = "{id}/items")
    public void newItemList(@PathVariable("id") Integer id, @RequestBody Item item){
        item.setShoppingListID(id);
        shoppinglistservice.addNemItemList(id, item);
    }

    @GetMapping(path = "{id}/items")
    public List<Item> GetItemLists(@PathVariable("id") Integer id){
        return shoppinglistservice.GetItemLists(id);
    }

    @GetMapping(path = "{id}/items/{itemId}")
    public Optional<Item> GetSingleItem(@PathVariable("id") Integer id, @PathVariable("itemId") Integer itemId){
        return shoppinglistservice.GetSingleItem(id, itemId);
    }

    @PutMapping(path = "{id}/items/{itemId}")
    public void updateItemList(
            @PathVariable("id") Integer id,
            @PathVariable("itemId") Integer itemId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) Integer quantity){
        shoppinglistservice.updateItemList(id, itemId, name, quantity);
    }

    @DeleteMapping(path = "{id}/items/{itemId}")
    public void DeleteSingleItem(@PathVariable("id") Integer id, @PathVariable("itemId") Integer itemId){
        shoppinglistservice.DeleteSingleItem(id, itemId);
    }


}
