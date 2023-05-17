package com.rms.rentalmanagementsystem.controller;

import com.rms.rentalmanagementsystem.dto.TenantRequestDto;
import com.rms.rentalmanagementsystem.service.TenantService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TenantController {
    private final TenantService tenantService;

    public TenantController(TenantService tenantService) {
        this.tenantService = tenantService;
    }

    @PostMapping(value = "/tenant/add")
    public String addTenant(@RequestBody TenantRequestDto tenantRequestDto) {
    tenantService.addTenantDto(tenantRequestDto);
    return "Tenant Registered Successfully";
    }
}
