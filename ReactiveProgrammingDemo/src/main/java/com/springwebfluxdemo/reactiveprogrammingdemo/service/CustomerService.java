package com.springwebfluxdemo.reactiveprogrammingdemo.service;

import com.springwebfluxdemo.reactiveprogrammingdemo.dao.CustomerDao;
import com.springwebfluxdemo.reactiveprogrammingdemo.dto.Customer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerDao customerDao;

    public List<Customer> loadAllCustomers() {
        long start = System.currentTimeMillis();
        List<Customer> customers = customerDao.getCustomer();
        long end = System.currentTimeMillis();
        System.out.println("Time Difference: " + (end - start));
        return customers;
    }

    public Flux<Customer> loadAllCustomersStream() {
        long start = System.currentTimeMillis();
        Flux<Customer> customers = customerDao.getCustomerStream();
        long end = System.currentTimeMillis();
        System.out.println("Time Difference: " + (end - start));
        return customers;
    }
}
