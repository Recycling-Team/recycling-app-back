package com.recycleapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.CommandLineRunner;

import com.recycleapp.model.Item;
import com.recycleapp.model.ItemRepository;
import com.recycleapp.model.Usera;
import com.recycleapp.model.UserRepository;

import java.sql.*;
import java.util.*;
import java.util.logging.Logger;

@SpringBootApplication
public class RecycleApp {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(RecycleApp.class, args);
    }


    @Bean
    public CommandLineRunner recycleDemo(ItemRepository itemRepo, UserRepository userRepo) {
        return (args) -> {
            //log.info("Saving Recycle demo data");

            Usera user1 = new Usera("Tavis");
            Usera user2 = new Usera("Pro");

            userRepo.save(user1);
            userRepo.save(user2);

            Item item1 = new Item("sohva");
            Item item2 = new Item("Kenkä");
            Item item3 = new Item("Säkkituoli");
            Item item4 = new Item("Silitysrauta");

            itemRepo.save(item1);
            itemRepo.save(item2);
            itemRepo.save(item3);
            itemRepo.save(item4);
        };
    }
}