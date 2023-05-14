package com.example.springbootjpademo.dto;

import com.example.springbootjpademo.entity.Address;
import com.example.springbootjpademo.entity.Awards;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeRequestDto implements Serializable {
    private String name;
    private Address address;
    private List<Awards> awards;
}
