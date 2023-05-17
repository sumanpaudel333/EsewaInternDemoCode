package com.rms.rentalmanagementsystem.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.rms.rentalmanagementsystem.enums.UserStatusEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
/*
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
This helps to remove jackson error for the cause of stackoverflow */
public class Landlord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "landlord_id")
    private int id;
    @Column(name = "landlord_name")
    private String name;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "contact_id")
    private Contact contact;
    @Column(name = "account_number")
    private String accountNumber;
    @OneToMany(mappedBy = "landlord", cascade = CascadeType.ALL)
    private List<Property> property = new ArrayList<>();
    @Column(name = "user_status")
    private UserStatusEnum userStatus;
}
