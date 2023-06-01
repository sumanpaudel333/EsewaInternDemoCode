package com.microservice.employeeservice.service;

import com.microservice.employeeservice.dto.AddressResponse;
import com.microservice.employeeservice.dto.ResponseEmployee;
import com.microservice.employeeservice.entity.Employee;
import com.microservice.employeeservice.feign.AddressClient;
import com.microservice.employeeservice.repo.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;
    private final AddressClient addressClient;
    private final RestTemplate restTemplate;
    private final WebClient webClient;

    public ResponseEmployee getEmployeeById(int id) {
        AddressResponse addressResponse;
        Employee employee = employeeRepository.findById(id).orElseThrow();
        ResponseEmployee employee1 = modelMapper.map(employee, ResponseEmployee.class);
        addressResponse = addressClient.getAddressByEmployeeId(id);
        employee1.setAddressResponse(addressResponse);
        return employee1;
    }

    public List<ResponseEmployee> getAllEmployee() {
        List<Employee> employee = employeeRepository.findAll();
//        List<ResponseEmployee> responseEmployees = new ArrayList<>();
        List<AddressResponse> addressResponses = addressClient.getAllAddress().getBody();
        List<ResponseEmployee> responseEmployees1 = Arrays.asList(modelMapper.map(employee, ResponseEmployee[].class));
        responseEmployees1.forEach(employee1 -> {
            assert addressResponses != null;
            for (AddressResponse addressResponse : addressResponses) {
                if (addressResponse.getEmployee_id() == employee1.getId()) {
                    employee1.setAddressResponse(addressResponse);
                }
            }
        });
        // Alternative Approach to convert employee to employee response and set address to employee
        /*for (Employee employee1 : employee) {
            ResponseEmployee responseEmployee = new ResponseEmployee();
            responseEmployee.setId(employee1.getId());
            responseEmployee.setName(employee1.getName());
            responseEmployee.setEmail(employee1.getEmail());
            responseEmployee.setBloodGroup(employee1.getBloodGroup());
            for (AddressResponse addressResponse1 : addressResponses) {
                AddressResponse addressResponse2 = new AddressResponse();
                if (addressResponse.getId()==employee1.getId()){
                addressResponse2.setId(addressResponse1.getId());
                addressResponse2.setCity(addressResponse1.getCity());
                addressResponse2.setState(addressResponse1.getState());
                addressResponse2.setStreet(addressResponse1.getStreet());
                responseEmployee.setAddressResponse(addressResponse1);
                }
            }
            responseEmployees.add(responseEmployee);
        }*/
        return responseEmployees1;
    }

    public String addEmployee(ResponseEmployee responseEmployee) {
        Employee employee = modelMapper.map(responseEmployee, Employee.class);
        AddressResponse addressResponse = responseEmployee.getAddressResponse();
        Employee employee1 = employeeRepository.save(employee);
        addressResponse.setEmployee_id(employee1.getId());
        addressClient.addNewAddress(addressResponse);
        return "Employee Added Successfully";
    }

    public List<AddressResponse> getAllAddress() {
        return addressClient.getAllAddress().getBody();
    }

    private AddressResponse callingAddressServiceUsingWebClient(int id) {
        return webClient
                .get()
                .uri("http://localhost:8081/address/" + id)
                .retrieve().bodyToMono(AddressResponse.class)
                .block();
    }

    private AddressResponse callingAddressServiceUsingRestTemplate(int id) {
        return restTemplate.getForObject("http://localhost:8081/address/{id}", AddressResponse.class, id);
    }
}
