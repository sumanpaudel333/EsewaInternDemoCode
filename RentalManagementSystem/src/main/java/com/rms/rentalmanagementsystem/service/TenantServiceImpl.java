package com.rms.rentalmanagementsystem.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rms.rentalmanagementsystem.dto.TenantRequestDto;
import com.rms.rentalmanagementsystem.dto.TenantResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TenantServiceImpl implements TenantService {
    private final ObjectMapper objectMapper;

    public TenantServiceImpl(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    public void addTenantDto(TenantRequestDto tenantRequestDto) {

    }

    @Override
    public List<TenantResponseDto> getAllTenant() {
        return null;
    }

    @Override
    public TenantResponseDto getTenantById(int id) {
        return null;
    }

    @Override
    public void updateTenantById(int id, TenantRequestDto tenantRequestDto) {

    }

    @Override
    public void deleteTenantById(int id) {

    }
}
