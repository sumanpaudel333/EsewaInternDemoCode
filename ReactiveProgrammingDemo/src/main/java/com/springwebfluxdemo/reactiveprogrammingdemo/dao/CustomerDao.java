package com.springwebfluxdemo.reactiveprogrammingdemo.dao;

import com.springwebfluxdemo.reactiveprogrammingdemo.dto.Customer;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Component
public class CustomerDao {
    private static void sleep(int i) {
        try {
            Thread.sleep(1000);

        } catch (InterruptedException e) {
            System.out.println("Exception Occurred: " + e);
        }
    }

    public List<Customer> getCustomer() {
        return IntStream.rangeClosed(1, 50)
                .peek(CustomerDao::sleep)
                .peek(i -> System.out.println("Processing Count: " + i))
                .mapToObj(i -> new Customer(i, "Customer" + i))
                .collect(Collectors.toList());
    }

    public Flux<Customer> getCustomerStream() {
        return Flux.range(1, 50)
                .delayElements(Duration.ofSeconds(1))
                .doOnNext(i -> System.out.println("Processing Count in stream flow: " + i))
                .map(i -> new Customer(i, "Customer " + i));
    }
}
