package com.rms.rentalmanagementsystem.entity;

import com.fasterxml.jackson.databind.annotation.JsonAppend;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Landlord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "landlord_id")
    private double id;
    @Column(name ="landlord_name")
    private String name;
    @OneToOne
    @JoinColumn(name = "contact_id")
    private Contact contact;
    @Column(name = "account_number")
    private String accountNumber;
    @OneToMany(mappedBy = "landlord",cascade = CascadeType.ALL)
    private List<Property> property;
}
