package com.example.springbootjpademo.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Employee {
    @Id
    @Column(name = "emp_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int emp_id;
    @Column(name = "emp_name")
    private String emp_name;
    @Column(name = "emp_address")
    private String emp_address;
}
