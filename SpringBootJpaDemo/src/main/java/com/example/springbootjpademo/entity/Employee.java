package com.example.springbootjpademo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Employee {
    @Id
    @Column(name = "emp_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int emp_id;

    @Column(name = "emp_name")
    private String emp_name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "add_id")
    private Address emp_address;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "emp_id")
    private List<Awards> awards;
}
