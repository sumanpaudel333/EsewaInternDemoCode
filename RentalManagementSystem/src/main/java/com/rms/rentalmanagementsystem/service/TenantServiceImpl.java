package com.rms.rentalmanagementsystem.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rms.rentalmanagementsystem.dto.TenantRequestDto;
import com.rms.rentalmanagementsystem.dto.TenantResponseDto;
import com.rms.rentalmanagementsystem.entity.Tenant;
import com.rms.rentalmanagementsystem.repo.TenantRepository;
import com.rms.rentalmanagementsystem.resources.ConvertToDto;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TenantServiceImpl implements TenantService {
    private final ObjectMapper objectMapper;
    private final TenantRepository tenantRepository;

    public TenantServiceImpl(ObjectMapper objectMapper, TenantRepository tenantRepository) {
        this.objectMapper = objectMapper;
        this.tenantRepository = tenantRepository;
    }

    @Override
    public void addTenantDto(TenantRequestDto tenantRequestDto) {
        ConvertToDto toDto=new ConvertToDto();
        Tenant tenant=toDto.tenantRequestDtoToTenant(tenantRequestDto);
        tenantRepository.save(tenant);
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
