package com.rms.rentalmanagementsystem.controller;

import com.rms.rentalmanagementsystem.dto.TenantRequestDto;
import com.rms.rentalmanagementsystem.dto.TenantResponseDto;
import com.rms.rentalmanagementsystem.service.TenantService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @GetMapping(value = "/tenant/getall")
    public List<TenantResponseDto> getAllTenant(){
       return tenantService.getAllTenant();
    }
    @GetMapping(value = "/tenant/gettenantbyid/{id}")
    public TenantResponseDto getTenantById(@PathVariable int id){
       return tenantService.getTenantById(id);
    }
    @PutMapping(value = "/tenant/update/{id}")
    public String updateTenantById(@PathVariable int id,@RequestBody TenantRequestDto tenantRequestDto){
        tenantService.updateTenantById(id,tenantRequestDto);
        return "User Updated Successfully";
    }
    @PostMapping(value = "/tenant/delete/{id}")
    public String deleteTenantById(@PathVariable int id){
        tenantService.deleteTenantById(id);
        return "User Deleted Successfully";
    }
}
