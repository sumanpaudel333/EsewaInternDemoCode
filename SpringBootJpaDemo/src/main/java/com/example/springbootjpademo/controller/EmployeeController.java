package com.example.springbootjpademo.controller;

import com.example.springbootjpademo.dto.AddressDto;
import com.example.springbootjpademo.dto.EmployeeDto;
import com.example.springbootjpademo.entity.Employee;
import com.example.springbootjpademo.exception.ResourceNotFoundException;
import com.example.springbootjpademo.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(value = "/")
    public ResponseEntity<EmployeeDto> getAllEmployee() {
        return new ResponseEntity<>(employeeService.getAllEmployee(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable int id) {
        return employeeService.getEmployeeById(id).orElseThrow(() -> new ResourceNotFoundException());
    }

    @PostMapping(value = "/add")
    public EmployeeDto addEmployee(@RequestBody Employee employee) {
        employeeService.addEmployee(employee);
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setName(employee.getEmp_name());
        AddressDto addressDto = new AddressDto();
        addressDto.setCity(employee.getEmp_address().getCity());
        addressDto.setStreet(employee.getEmp_address().getStreet());
        employeeDto.setAddress(addressDto);
        return employeeDto;
    }

    @DeleteMapping(value = "/delete/{id}")
    public EmployeeDto deleteEmployee(@PathVariable int id) {
        employeeService.deleteEmployeeById(id);
        return employeeService.getAllEmployee();
    }

    @PutMapping(value = "/update/{id}")
    public String updateEmployee(@PathVariable int id, @RequestBody Employee employee) {
        employeeService.updateEmployeeById(id, employee);
        return employee + " Update Successfully";
    }
}

