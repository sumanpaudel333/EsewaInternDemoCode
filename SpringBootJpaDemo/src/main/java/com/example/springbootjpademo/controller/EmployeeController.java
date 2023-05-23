package com.example.springbootjpademo.controller;

import com.example.springbootjpademo.dto.EmployeeRequestDto;
import com.example.springbootjpademo.dto.EmployeeResponseDto;
import com.example.springbootjpademo.entity.Employee;
import com.example.springbootjpademo.exception.ResourceNotFoundException;
import com.example.springbootjpademo.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(value = "/api/employee/getall")
    public EmployeeResponseDto getAllEmployee() {
        return employeeService.getAllEmployee();
    }

    @GetMapping("/api/employee/{id}")
    public Employee getEmployeeById(@PathVariable int id) {
        return employeeService.getEmployeeById(id).orElseThrow(ResourceNotFoundException::new);
    }

    @PostMapping(value = "/api/employee/add")
    public EmployeeResponseDto addEmployee(@RequestBody EmployeeRequestDto employee) {
        return employeeService.addEmployee(employee);
    }

    @DeleteMapping(value = "/api/employee/delete/{id}")
    public EmployeeResponseDto deleteEmployee(@PathVariable int id) {
        employeeService.deleteEmployeeById(id);
        return employeeService.getAllEmployee();
    }

    @PutMapping(value = "/api/employee/update/{id}")
    public String updateEmployee(@PathVariable int id, @RequestBody Employee employee) {
        employeeService.updateEmployeeById(id, employee);
        return employee + " Update Successfully";
    }
}

