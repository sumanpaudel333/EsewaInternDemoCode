package com.microservice.addressservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddressResponse implements Serializable {
    private int id;
    private String street;
    private String city;
    private String state;
    private int employee_id;
}
