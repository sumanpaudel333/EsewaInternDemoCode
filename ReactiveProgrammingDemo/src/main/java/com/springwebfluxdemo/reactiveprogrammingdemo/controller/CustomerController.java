package com.springwebfluxdemo.reactiveprogrammingdemo.controller;

import com.springwebfluxdemo.reactiveprogrammingdemo.dto.Customer;
import com.springwebfluxdemo.reactiveprogrammingdemo.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.util.List;

@RestController
@RequestMapping("/api/customer")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;

    @GetMapping("/getallcustomer")
    public List<Customer> getAllCustomer() {
        return customerService.loadAllCustomers();
    }

    @GetMapping(value = "/getallcustomerbyreactive", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Customer> getAllCustomerStream() {
        return customerService.loadAllCustomersStream();
    }
}
