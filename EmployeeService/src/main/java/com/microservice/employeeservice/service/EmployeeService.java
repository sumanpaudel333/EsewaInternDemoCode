package com.microservice.employeeservice.service;

import com.microservice.employeeservice.dto.AddressResponse;
import com.microservice.employeeservice.dto.ResponseEmployee;
import com.microservice.employeeservice.entity.Employee;
import com.microservice.employeeservice.repo.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;
    private final WebClient webClient;
    private final RestTemplate restTemplate;
//    private final DiscoveryClient client;
//    private final LoadBalancerClient loadBalancerClient;
    public ResponseEmployee getEmployeeById(int id) {
        AddressResponse addressResponse;
        Employee employee = employeeRepository.findById(id).orElseThrow();
        ResponseEmployee employee1 = modelMapper.map(employee, ResponseEmployee.class);
        addressResponse = callingAddressServiceUsingRestTemplate(id);
        employee1.setAddressResponse(addressResponse);
        return employee1;
    }

    private AddressResponse callingAddressServiceUsingWebClient(int id) {
        return webClient
                .get()
                .uri("http://localhost:8081/address/" + id)
                .retrieve().bodyToMono(AddressResponse.class)
                .block();
    }

    private AddressResponse callingAddressServiceUsingRestTemplate(int id) {
       /* List<ServiceInstance> serviceInstances=client.getInstances("Address-Service");
       ServiceInstance serviceInstance= serviceInstances.get(0);
       String uri= serviceInstance.getUri().toString();*/
        //load balancing through service instance and invoking loadbalancer
       /*ServiceInstance serviceInstance=loadBalancerClient.choose("Address-Service");
       String uri=serviceInstance.getUri().toString();
       String contextRoot=serviceInstance.getMetadata().get("configPath");
        System.out.println(">>>>>>>>> "+uri);*/
        System.out.println("Balancing load through Rest Template");
        return restTemplate.getForObject("http://Address-service/address/{id}",AddressResponse.class,id);
    }
}
