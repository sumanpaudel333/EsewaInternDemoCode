package com.example.multipledatabaseconnectiontask;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
public class MultipleDatabaseConnectionTaskApplication {

    public static void main(String[] args) {
        SpringApplication.run(MultipleDatabaseConnectionTaskApplication.class, args);
    }

}
