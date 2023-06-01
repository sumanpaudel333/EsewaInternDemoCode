package com.microservice.employeeservice.controller;

import com.microservice.employeeservice.dto.AddressResponse;
import com.microservice.employeeservice.dto.ResponseEmployee;
import com.microservice.employeeservice.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/employees/")
public class EmployeeController {
    private final EmployeeService employeeService;
    @GetMapping("{id}")
    public ResponseEntity<ResponseEmployee> getEmployeeDetails(@PathVariable int id) {
        return ResponseEntity.status(HttpStatus.FOUND).body(employeeService.getEmployeeById(id));
    }
    @GetMapping("getall")
    public ResponseEntity<List<ResponseEmployee>> getAllEmployeeDetails() {
        return ResponseEntity.status(HttpStatus.FOUND).body(employeeService.getAllEmployee());
    }
    @GetMapping("address/get-all")
    public ResponseEntity<List<AddressResponse>> getAllAddress(){
        return ResponseEntity.status(HttpStatus.FOUND).body(employeeService.getAllAddress());
    }
    @PostMapping("addemployee")
    public String addNewAddress(@RequestBody ResponseEmployee responseEmployee){
        return employeeService.addEmployee(responseEmployee);
    }
}
