package com.microservice.employeeservice.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class EmployeeAppConfig {
    @Bean
    ModelMapper modelMapper(){
        return new ModelMapper();
    }
    @Bean
    WebClient webClient(){
        return WebClient.builder().build();
    }
    @Bean
    RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
