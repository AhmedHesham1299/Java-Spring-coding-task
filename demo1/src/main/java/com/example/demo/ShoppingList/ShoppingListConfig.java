package com.example.demo.ShoppingList;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.awt.event.ItemEvent;
import java.util.List;

@Configuration
public class ShoppingListConfig {
    @Bean
    CommandLineRunner commandLineRunner(ShoppingListRepository repository){
        return args -> {
           ShoppingList Ahmed =  new ShoppingList("Ahmed");
           ShoppingList Ali =  new ShoppingList("Ali");
           repository.saveAll(List.of(Ahmed,Ali));
        };
    }


}
