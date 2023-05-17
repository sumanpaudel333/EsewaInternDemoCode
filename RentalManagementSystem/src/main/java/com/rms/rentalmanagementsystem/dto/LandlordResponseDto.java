package com.rms.rentalmanagementsystem.dto;

import com.rms.rentalmanagementsystem.entity.Contact;
import com.rms.rentalmanagementsystem.entity.Property;
import lombok.Data;

@Data
public class LandlordResponseDto {
    private int id;
    private String name;
    private Contact contact;
    private String accountNumber;
    private int no_of_properties;
}
