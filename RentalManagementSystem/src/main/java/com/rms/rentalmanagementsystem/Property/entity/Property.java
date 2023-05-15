package com.rms.rentalmanagementsystem.Property.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rms.rentalmanagementsystem.Landlord.entity.Landlord;
import com.rms.rentalmanagementsystem.Property.enums.PropertyStatusEnum;
import com.rms.rentalmanagementsystem.Property.enums.PropertyTypeEnum;
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
public class Property {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "property_id")
    private int propertyId;
    @Column(name = "property_address")
    private String address;
    @Enumerated(EnumType.STRING)
    @Column(name = "property_type")
    private PropertyTypeEnum propertyType;
    @Column(name = "rent_amount")
    private double rentAmount;
    @Enumerated(EnumType.STRING)
    @Column(name = "property_status")
    private PropertyStatusEnum propertyStatus;
    /*@OneToMany
    private List<Payment> payment;*/
    @ManyToOne
    @JoinColumn(name = "landlord_id")
    @JsonIgnore
    private Landlord landlord;
}
