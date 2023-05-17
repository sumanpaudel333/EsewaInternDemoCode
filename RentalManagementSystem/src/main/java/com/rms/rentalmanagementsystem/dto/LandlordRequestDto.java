package com.rms.rentalmanagementsystem.dto;

import com.rms.rentalmanagementsystem.entity.Contact;
import com.rms.rentalmanagementsystem.entity.Property;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class LandlordRequestDto implements Serializable {
    private String name;
    private Contact contact;
    private String accountNumber;
    private List<Property> property;
}
