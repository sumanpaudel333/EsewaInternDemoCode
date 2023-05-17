package com.rms.rentalmanagementsystem.service;

import com.rms.rentalmanagementsystem.dto.*;

import java.util.List;

public interface TenantService {
    void addTenantDto(TenantRequestDto tenantRequestDto);

    List<TenantResponseDto> getAllTenant();

    TenantResponseDto getTenantById(int id);

    void updateTenantById(int id, TenantRequestDto tenantRequestDto);

    void deleteTenantById(int id);
}
