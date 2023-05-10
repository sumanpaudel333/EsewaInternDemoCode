package com.example.springbootjpademo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Table(name = "address")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int add_id;
    private String city;
    private String street;
    /*@OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "emp_id")
    private Employee employee;*/
}
