package com.springwebfluxdemo.reactiveprogrammingdemo.handler;

import com.springwebfluxdemo.reactiveprogrammingdemo.dao.CustomerDao;
import com.springwebfluxdemo.reactiveprogrammingdemo.dto.Customer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class CustomerHandler {
    private final CustomerDao customerDao;

    public Mono<ServerResponse> loadCustomers(ServerRequest serverRequest) {
        Flux<Customer> customerList = customerDao.getCustomerList();
        return ServerResponse.ok()
                .contentType(MediaType.TEXT_EVENT_STREAM)
                .body(customerList, Customer.class);
    }

    public Mono<ServerResponse> loadAllCustomers(ServerRequest serverRequest) {
        Flux<Customer> customerList = customerDao.getCustomerStream();
        return ServerResponse.ok()
                .contentType(MediaType.TEXT_EVENT_STREAM)
                .body(customerList, Customer.class);
    }
}
