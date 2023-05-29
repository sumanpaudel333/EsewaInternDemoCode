package com.microservice.employeeservice.service;

import com.microservice.employeeservice.dto.AddressResponse;
import com.microservice.employeeservice.dto.ResponseEmployee;
import com.microservice.employeeservice.entity.Employee;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import com.microservice.employeeservice.repo.EmployeeRepository;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;
    private final WebClient webClient;
//    private final RestTemplate restTemplate;
    public ResponseEmployee getEmployeeById(int id) {
        AddressResponse addressResponse=new AddressResponse();
        Employee employee=employeeRepository.findById(id).orElseThrow();
        ResponseEmployee employee1= modelMapper.map(employee, ResponseEmployee.class);
        addressResponse=webClient.get().uri("http://localhost:8081/address/"+id).retrieve().bodyToMono(AddressResponse.class).block();
        employee1.setAddressResponse(addressResponse);
        return employee1;
    }
}
