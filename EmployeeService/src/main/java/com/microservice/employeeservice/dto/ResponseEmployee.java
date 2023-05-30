package com.microservice.employeeservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseEmployee {
    private int id;
    private String name;
    private String email;
    private String bloodGroup;
    private AddressResponse addressResponse;
}
