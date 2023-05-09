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
public class Employee implements Serializable {
    @Id
    @Column(name = "emp_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int emp_id;

    @Column(name = "emp_name")
    private String emp_name;

    @JoinColumn(name = "emp_address")
    @OneToOne
    private Address emp_address;
}
