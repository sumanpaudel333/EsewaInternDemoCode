package com.microservice.employeeservice.feign;

import feign.Feign;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.context.annotation.Bean;
@LoadBalancerClient(name = "Address-Service",configuration = MyCustomLoadBalancer.class)
public class AddressServiceLoadBalancer {
    @LoadBalanced
    @Bean
    public Feign.Builder builder(){
        return Feign.builder();
    }

}
