package com.example.springbootjpademo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressDto implements Serializable {
    private String city;
    private String street;
}
