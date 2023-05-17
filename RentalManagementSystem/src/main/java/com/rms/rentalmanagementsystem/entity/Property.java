package com.rms.rentalmanagementsystem.entity;

import com.rms.rentalmanagementsystem.enums.PropertyStatusEnum;
import com.rms.rentalmanagementsystem.enums.PropertyTypeEnum;
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
    @ManyToOne
    @JoinColumn(name = "landlord_id")
    private Landlord landlord;
}
