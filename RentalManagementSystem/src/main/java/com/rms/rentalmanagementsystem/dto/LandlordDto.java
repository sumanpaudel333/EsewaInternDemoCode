package com.rms.rentalmanagementsystem.dto;

import com.rms.rentalmanagementsystem.entity.Contact;
import com.rms.rentalmanagementsystem.entity.Property;

import java.util.List;

public class LandlordDto {
    private String name;

    private Contact contact;
    private String accountNumber;
    private List<Property> property;
}
