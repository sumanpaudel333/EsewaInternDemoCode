package com.rms.rentalmanagementsystem.dto;

import com.rms.rentalmanagementsystem.entity.Contact;
import lombok.Data;

@Data
public class TenantResponseDto {
    private String tenantName;
    private Contact contact;
}
