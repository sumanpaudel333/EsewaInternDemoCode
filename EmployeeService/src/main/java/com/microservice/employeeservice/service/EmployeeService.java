package com.microservice.employeeservice.service;

import com.microservice.employeeservice.dto.AddressResponse;
import com.microservice.employeeservice.dto.ResponseEmployee;
import com.microservice.employeeservice.entity.Employee;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import com.microservice.employeeservice.repo.EmployeeRepository;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;
    private final RestTemplate restTemplate;
    public ResponseEmployee getEmployeeById(int id) {
        AddressResponse addressResponse=new AddressResponse();
        Employee employee=employeeRepository.findById(id).orElseThrow();
        ResponseEmployee employee1= modelMapper.map(employee, ResponseEmployee.class);
        addressResponse=restTemplate.getForObject("http://localhost:8081/address/{id}", AddressResponse.class,id);
        employee1.setAddressResponse(addressResponse);
        return employee1;
    }
}
