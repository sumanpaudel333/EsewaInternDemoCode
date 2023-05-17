package com.rms.rentalmanagementsystem.dto;

import com.rms.rentalmanagementsystem.entity.Landlord;
import com.rms.rentalmanagementsystem.enums.PropertyStatusEnum;
import com.rms.rentalmanagementsystem.enums.PropertyTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PropertyDto implements Serializable {
    private String address;

    private PropertyTypeEnum propertyType;

    private PropertyStatusEnum propertyStatus;

    private double rentAmount;

    private int landlord_id;
}
