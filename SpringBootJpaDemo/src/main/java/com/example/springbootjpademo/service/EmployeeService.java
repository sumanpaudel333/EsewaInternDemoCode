package com.example.springbootjpademo.service;

import com.example.springbootjpademo.dto.EmployeeDto;
import com.example.springbootjpademo.entity.Address;
import com.example.springbootjpademo.entity.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    EmployeeDto getAllEmployee();

    Optional<Employee> getEmployeeById(int id);

    String addEmployee(Employee employee);
    String addAddress(Address address);

    String deleteEmployeeById(int id);

    String updateEmployeeById(int id, Employee employee);
}
