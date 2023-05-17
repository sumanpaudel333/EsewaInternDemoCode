package com.rms.rentalmanagementsystem.dto;

import com.rms.rentalmanagementsystem.entity.Tenant;
import jakarta.persistence.ManyToOne;

public class LeaseRequestDto {
    @ManyToOne
    private Tenant tenant;

}
