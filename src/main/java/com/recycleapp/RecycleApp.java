package com.recycleapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.recycleapp.model.ItemRepository;
import com.recycleapp.model.ReservationRepository;
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
    public CommandLineRunner recycleDemo(ItemRepository itemRepo, UserRepository userRepo,
			ReservationRepository reservationRepo) {
		return (args) -> {
            log.info("Saving Recycle demo data");
            
            User user1 = new User("Tavis");
            User user2 = new User("Pro");

}