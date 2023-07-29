package com.example.demo.ShoppingList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ItemListRepository extends JpaRepository<Item, Integer> {


}

