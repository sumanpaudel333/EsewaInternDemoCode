package com.rms.rentalmanagementsystem.Landlord.dto;

import com.rms.rentalmanagementsystem.Contact.entity.Contact;
import com.rms.rentalmanagementsystem.Property.entity.Property;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class LandlordDto implements Serializable {
    private String name;
    private Contact contact;
    private String accountNumber;
    private List<Property> property;
}
