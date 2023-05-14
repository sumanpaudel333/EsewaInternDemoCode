package com.example.springbootjpademo.service;

import com.example.springbootjpademo.dto.AddressDto;
import com.example.springbootjpademo.dto.AwardDto;
import com.example.springbootjpademo.dto.EmployeeRequestDto;
import com.example.springbootjpademo.dto.EmployeeResponseDto;
import com.example.springbootjpademo.entity.Address;
import com.example.springbootjpademo.entity.Awards;
import com.example.springbootjpademo.entity.Employee;
import com.example.springbootjpademo.repository.AddressRepository;
import com.example.springbootjpademo.repository.AwardRepository;
import com.example.springbootjpademo.repository.EmployeeRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@Slf4j
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final AddressRepository addressRepository;
    private final AwardRepository awardRepository;


    public EmployeeServiceImpl(EmployeeRepository employeeRepository, AddressRepository addressRepository, AwardRepository awardRepository) {
        this.employeeRepository = employeeRepository;
        this.addressRepository = addressRepository;
        this.awardRepository = awardRepository;
    }

    @Override
    @Cacheable(value = "employee")
    public EmployeeResponseDto getAllEmployee() {
        EmployeeResponseDto employeeDto = new EmployeeResponseDto();
        AddressDto addressDto = new AddressDto();
        AwardDto awardDto = new AwardDto();
        log.info("getAllEmployee() from db");
        List<Employee> employees = employeeRepository.findAll();
        for (Employee employee : employees) {
            addressDto.setCity(employee.getEmp_address().getCity());
            addressDto.setStreet(employee.getEmp_address().getStreet());
            awardDto.setAward_name(employee.getAwards());
            employeeDto.setName(employee.getEmp_name());
            employeeDto.setAddress(addressDto);
            employeeDto.setAwardsList(awardDto);
        }
        log.info("Getting All Employees");
        return employeeDto;
    }
    @Override
    @Cacheable(value = "employee", key = "#id")
    public Optional<Employee> getEmployeeById(int id) {
        log.info("getting employee from db");
        return employeeRepository.findById(id);
    }

    @Override
    @CacheEvict(value = "employee", allEntries = true, key = "#employee")
    public EmployeeResponseDto addEmployee(EmployeeRequestDto employee) {
        Employee employee1 = new Employee();
        employee1.setEmp_name(employee.getName());
        employee1.setEmp_address(employee.getAddress());
        employee1.setAwards(employee.getAwards());
        employeeRepository.save(employee1);
        EmployeeResponseDto employeeResponseDto = new EmployeeResponseDto();
        AddressDto addressDto = new AddressDto();
        AwardDto awardDto = new AwardDto();
        awardDto.setAward_name(employee1.getAwards());
        addressDto.setCity(employee1.getEmp_address().getCity());
        addressDto.setStreet(employee1.getEmp_address().getStreet());
        employeeResponseDto.setAddress(addressDto);
        employeeResponseDto.setName(employee.getName());
        employeeResponseDto.setAwardsList(awardDto);
        log.info("Employee Added");
        return employeeResponseDto;
    }

    @Override
    @CacheEvict(value = "employee", allEntries = true)
    public String addAddress(Address address) {
        addressRepository.save(address);
        log.info("Address added Successfully");
        return "Address added Successfully";
    }

    @Override
    @CacheEvict(value = "employee", allEntries = true)
    public String addAwards(List<Awards> awards) {
        awardRepository.saveAll(awards);
        log.info("Awards added Successfully");
        return "Awards added Successfully";
    }

    @Override
    @CacheEvict(value = "employee", allEntries = true, key = "#id")
    public String deleteEmployeeById(int id) {
        employeeRepository.deleteById(id);
        log.info("User Deleted Successfully");
        return "User Deleted Successfully";
    }

    @Override
    @CachePut(value = "employee", key = "#id")
    public String updateEmployeeById(int id, Employee employee) {
        Employee employee1 = employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("Could not found employee"));
        employee1.setEmp_name(employee.getEmp_name());
        employee1.setEmp_address(employee.getEmp_address());
        employeeRepository.save(employee1);
        log.info("User Update successfully");
        return "User Update successfully";
    }
}
