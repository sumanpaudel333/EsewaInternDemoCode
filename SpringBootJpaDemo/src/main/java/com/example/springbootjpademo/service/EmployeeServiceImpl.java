package com.example.springbootjpademo.service;

import com.example.springbootjpademo.dto.AddressDto;
import com.example.springbootjpademo.dto.EmployeeDto;
import com.example.springbootjpademo.entity.Address;
import com.example.springbootjpademo.repository.AddressRepository;
import com.example.springbootjpademo.repository.EmployeeRepository;
import com.example.springbootjpademo.entity.Employee;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final AddressRepository addressRepository;


    public EmployeeServiceImpl(EmployeeRepository employeeRepository, AddressRepository addressRepository) {
        this.employeeRepository = employeeRepository;
        this.addressRepository = addressRepository;
    }

    @Override
    @Cacheable(value = "employee")
    public EmployeeDto getAllEmployee() {
        EmployeeDto employeeDto=new EmployeeDto();
        AddressDto addressDto=new AddressDto();
        System.out.println("getAllEmployee() from db");
        List<Employee> employees= employeeRepository.findAll();
        for (Employee employee:employees){
            addressDto.setCity(employee.getEmp_address().getCity());
            addressDto.setStreet(employee.getEmp_address().getStreet());
            employeeDto.setName(employee.getEmp_name());
            employeeDto.setAddress(addressDto);
        }
        return employeeDto;
    }
    @Override
    @Cacheable(value = "employee",key = "#id")
    public Optional<Employee> getEmployeeById(int id) {
        System.out.println("getting employee from db");
        return employeeRepository.findById(id);
    }

    @Override
    @CacheEvict(value = "employee",allEntries = true,key = "#employee")
    public String addEmployee(Employee employee) {
        employeeRepository.save(employee);
        return "User added Successfully";
    }
    @Override
    @CacheEvict(value = "employee",allEntries = true,key = "#employee")
    public String addAddress(Address address) {
        addressRepository.save(address);
        return "User added Successfully";
    }

    @Override
    @CacheEvict(value = "employee",allEntries = true,key = "#id")
    public String deleteEmployeeById(int id) {
        employeeRepository.deleteById(id);
        return "User Deleted Successfully";
    }
    @Override
    @CachePut(value = "employee",key = "#id")
    public String updateEmployeeById(int id, Employee employee) {
        Employee employee1 = employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("Could not found employee"));
        employee1.setEmp_name(employee.getEmp_name());
        employee1.setEmp_address(employee.getEmp_address());
        employeeRepository.save(employee1);
        return "User Update successfully";
    }
}
