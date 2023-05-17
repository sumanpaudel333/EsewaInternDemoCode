package com.rms.rentalmanagementsystem.dto;

import com.rms.rentalmanagementsystem.entity.Contact;
import lombok.Data;

@Data
public class TenantRequestDto {
    private String tenantName;
    private Contact contact;
}
