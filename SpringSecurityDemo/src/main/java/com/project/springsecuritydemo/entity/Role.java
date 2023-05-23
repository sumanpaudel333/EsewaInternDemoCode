package com.project.springsecuritydemo.entity;

import com.project.springsecuritydemo.enums.RoleStatusEnum;
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
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private int roleId;
    @Column(name = "role_status")
    @Enumerated(EnumType.STRING)
    private RoleStatusEnum roleStatus;
}
