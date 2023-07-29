package com.example.demo.ShoppingList;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ShoppingListService {
    private final ShoppingListRepository shoppingListRepository ;

    private final ItemListRepository itemListRepository;
    @Autowired
    public ShoppingListService(ShoppingListRepository shoppingListRepository, ItemListRepository itemListRepository) {
        this.shoppingListRepository = shoppingListRepository;
        this.itemListRepository = itemListRepository;
    }

    public List<ShoppingList> GetShoppingLists(){
        return this.shoppingListRepository.findAll();
    }
    public void addNewList(ShoppingList shoppingList){
         shoppingListRepository.save(shoppingList);
    }
    @Transactional
    public ShoppingList GetShoppingList(Integer id){
        ShoppingList shoppingList = shoppingListRepository.findById(id).orElseThrow(() -> new IllegalStateException("ShoppingList with ID " + id + " does not exist"));
        return shoppingList;
    }
    @Transactional
    public void updateShoppingList(Integer id, String name){
        ShoppingList shoppingList = shoppingListRepository.findById(id).orElseThrow(() -> new IllegalStateException("ShoppingList with ID " + id + " does not exist"));
        if(name!= null && name.length()>0 && !Objects.equals(shoppingList.getName(), name)){
            shoppingList.setName(name);
        }
    }

    @Transactional
    public  void DeleteShoppingList(Integer id){
        ShoppingList shoppingList = shoppingListRepository.findById(id).orElseThrow(() -> new IllegalStateException("ShoppingList with ID " + id + " does not exist"));
         shoppingListRepository.delete(shoppingList);
    }
    @Transactional
    public void addNemItemList(Integer id, Item item){
        ShoppingList shoppingList = shoppingListRepository.findById(id).orElseThrow(() -> new IllegalStateException("ShoppingList with ID" + id + " does not exist"));
        itemListRepository.save(item);
    }

    @Transactional
    public List<Item> GetItemLists(Integer id){
        ShoppingList shoppingList = shoppingListRepository.findById(id).orElseThrow(() -> new IllegalStateException("ShoppingList with ID " + id + " does not exist"));
        List<Item> G = itemListRepository.findAll();
        for(int i =0; i< G.size(); i++ ){
           if(G.get(i).getShoppingListID()!=id){
               G.remove(i);
           }
        }
        return G;
    }
    @Transactional
    public Optional<Item> GetSingleItem(Integer id, Integer itemId){
        ShoppingList shoppingList = shoppingListRepository.findById(id).orElseThrow(() -> new IllegalStateException("ShoppingList with ID " + id + "does not exist"));
        Item Item = itemListRepository.findById(itemId).orElseThrow(() -> new IllegalStateException("Item with ID " + id + " does not exist"));
        return itemListRepository.findById(itemId);
    }

    @Transactional
    public void updateItemList(Integer id, Integer itemId, String name, Integer quantity){
        ShoppingList shoppingList = shoppingListRepository.findById(id).orElseThrow(() -> new IllegalStateException("ShoppingList with ID " + id + "does not exist"));
        Item Item = itemListRepository.findById(itemId).orElseThrow(() -> new IllegalStateException("Item with ID " + id + " does not exist"));
        Item.setShoppingListID(id);
        if(name!= null && name.length()>0 && !Objects.equals(Item.getName(), name)){
            Item.setName(name);
        }
        Item.setQuantity(quantity);
    }

    @Transactional
    public  void DeleteSingleItem(Integer id, Integer itemId){
        ShoppingList shoppingList = shoppingListRepository.findById(id).orElseThrow(() -> new IllegalStateException("ShoppingList with ID " + id + "does not exist"));
        Item Item = itemListRepository.findById(itemId).orElseThrow(() -> new IllegalStateException("Item with ID " + id + " does not exist"));
        itemListRepository.delete(Item);
    }
}
