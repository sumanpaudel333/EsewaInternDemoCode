package com.example.springbootjpademo.controller;

import com.example.springbootjpademo.dto.EmployeeRequestDto;
import com.example.springbootjpademo.dto.EmployeeResponseDto;
import com.example.springbootjpademo.entity.Employee;
import com.example.springbootjpademo.exception.ResourceNotFoundException;
import com.example.springbootjpademo.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@RestController
@RequestMapping(value = "/api/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(value = "/")
    public ResponseEntity<EmployeeResponseDto> getAllEmployee() {
        return new ResponseEntity<>(employeeService.getAllEmployee(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable int id) {
        return employeeService.getEmployeeById(id).orElseThrow(ResourceNotFoundException::new);
    }

    @PostMapping(value = "/add")
    public EmployeeResponseDto addEmployee(@RequestBody EmployeeRequestDto employee) {
        return employeeService.addEmployee(employee);
    }

    @DeleteMapping(value = "/delete/{id}")
    public EmployeeResponseDto deleteEmployee(@PathVariable int id) {
        employeeService.deleteEmployeeById(id);
        return employeeService.getAllEmployee();
    }

    @PutMapping(value = "/update/{id}")
    public String updateEmployee(@PathVariable int id, @RequestBody Employee employee) {
        employeeService.updateEmployeeById(id, employee);
        return employee + " Update Successfully";
    }
}

