package com.example.springbootjpademo.dto;

import com.example.springbootjpademo.entity.Address;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto implements Serializable {
    private String name;
    private AddressDto address;
}
