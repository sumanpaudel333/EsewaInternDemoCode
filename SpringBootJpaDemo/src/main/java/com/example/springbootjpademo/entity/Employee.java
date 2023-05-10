package com.example.springbootjpademo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee{
    @Id
    @Column(name = "emp_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int emp_id;

    @Column(name = "emp_name")
    private String emp_name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "add_id")
    private Address emp_address;
}
