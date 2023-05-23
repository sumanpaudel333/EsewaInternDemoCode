package com.example.springbootjpademo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
@Slf4j
public class SpringBootJpaDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootJpaDemoApplication.class, args);
    }
}
