package com.example.springbootjpademo.dto;

import lombok.*;

import java.io.Serializable;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddressDto implements Serializable {
    private String city;
    private String street;
}
