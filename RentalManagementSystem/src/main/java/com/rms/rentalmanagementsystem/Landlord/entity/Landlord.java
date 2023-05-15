package com.rms.rentalmanagementsystem.Landlord.entity;

import com.rms.rentalmanagementsystem.Contact.entity.Contact;
import com.rms.rentalmanagementsystem.Property.entity.Property;
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
public class Landlord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "landlord_id")
    private int id;
    @Column(name ="landlord_name")
    private String name;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "contact_id")
    private Contact contact;
    @Column(name = "account_number")
    private String accountNumber;
    @OneToMany(mappedBy = "landlord",cascade = CascadeType.ALL)
    private List<Property> property=new ArrayList<>();
}
