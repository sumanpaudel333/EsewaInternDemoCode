package com.example.springbootjpademo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Awards {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int award_id;
    @Column(name = "award_name")
    private String awardName;
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Employee employee;
}
