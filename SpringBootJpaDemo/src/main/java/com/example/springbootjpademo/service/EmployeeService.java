package com.example.springbootjpademo.service;

import com.example.springbootjpademo.dto.EmployeeRequestDto;
import com.example.springbootjpademo.dto.EmployeeResponseDto;
import com.example.springbootjpademo.entity.Address;
import com.example.springbootjpademo.entity.Awards;
import com.example.springbootjpademo.entity.Employee;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    EmployeeResponseDto getAllEmployee();

    Optional<Employee> getEmployeeById(int id);

    EmployeeResponseDto addEmployee(EmployeeRequestDto employee);

    String addAddress(Address address);

    String addAwards(List<Awards> awards);

    String deleteEmployeeById(int id);

    String updateEmployeeById(int id, Employee employee);
}
