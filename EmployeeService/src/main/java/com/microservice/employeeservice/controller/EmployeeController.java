package com.microservice.employeeservice.controller;

import com.microservice.employeeservice.dto.ResponseEmployee;
import com.microservice.employeeservice.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeService employeeService;
    @GetMapping("/employees/{id}")
    public ResponseEntity<ResponseEmployee> getEmployeeDetails(@PathVariable int id) {
        return ResponseEntity.status(HttpStatus.FOUND).body(employeeService.getEmployeeById(id));
    }
}
