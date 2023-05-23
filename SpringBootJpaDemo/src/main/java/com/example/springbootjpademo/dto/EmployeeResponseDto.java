package com.example.springbootjpademo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeResponseDto implements Serializable {
    private String name;
    private AddressDto address;
    private AwardDto awardsList;
}
