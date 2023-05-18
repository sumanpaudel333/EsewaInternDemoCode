package com.rms.rentalmanagementsystem.resources;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rms.rentalmanagementsystem.dto.LandlordRequestDto;
import com.rms.rentalmanagementsystem.dto.LandlordResponseDto;
import com.rms.rentalmanagementsystem.dto.TenantRequestDto;
import com.rms.rentalmanagementsystem.dto.TenantResponseDto;
import com.rms.rentalmanagementsystem.entity.Landlord;
import com.rms.rentalmanagementsystem.entity.Property;
import com.rms.rentalmanagementsystem.entity.Tenant;
import com.rms.rentalmanagementsystem.enums.PropertyStatusEnum;
import com.rms.rentalmanagementsystem.enums.UserStatusEnum;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ConvertToDto {
    private ObjectMapper objectMapper;

    public LandlordResponseDto landlordToResponse(Landlord landlord) {
        LandlordResponseDto landlordResponseDto = new LandlordResponseDto();
        landlordResponseDto.setName(landlord.getName());
        landlordResponseDto.setContact(landlord.getContact());
        landlordResponseDto.setAccountNumber(landlord.getAccountNumber());
        landlordResponseDto.setNo_of_properties(landlord.getProperty().size());
        landlordResponseDto.setId(landlord.getId());
        return landlordResponseDto;
    }

    /*public Landlord landlordRequestToLandlord(LandlordRequestDto landlordRequestDto){
        Landlord landlord = objectMapper.convertValue(landlordRequestDto, Landlord.class);
        List<Property> properties = landlordRequestDto.getProperty();
        landlord.setUserStatus(UserStatusEnum.Active);
        for (Property property : properties) {
            property.setLandlord(landlord);
            property.setPropertyStatus(PropertyStatusEnum.Available);
        }
        landlord.setProperty(properties);
        return landlord;
    }*/
    public LandlordRequestDto landlordToLandlordRequestDto(Landlord landlord) {
        LandlordRequestDto requestDto = new LandlordRequestDto();
        requestDto.setProperty(landlord.getProperty());
        requestDto.setContact(landlord.getContact());
        requestDto.setName(landlord.getName());
        requestDto.setAccountNumber(landlord.getAccountNumber());
        return requestDto;
    }

    public Tenant tenantRequestDtoToTenant(TenantRequestDto tenantRequestDto) {
        Tenant tenant = new Tenant();
        tenant.setTenantName(tenantRequestDto.getTenantName());
        tenant.setContact(tenantRequestDto.getContact());
        tenant.setTenantStatus(UserStatusEnum.Active);
        return tenant;
    }

    public List<TenantResponseDto> listOfTenantToResponseList(List<Tenant> tenants) {
        List<TenantResponseDto> tenantResponseDtoList = new ArrayList<>();
        TenantResponseDto tenantResponseDto=new TenantResponseDto();
        for (Tenant tenant : tenants) {
            if (tenant.getTenantStatus().equals(UserStatusEnum.Active) || tenant.getTenantStatus().equals(UserStatusEnum.Inactive)) {
                tenantResponseDto.setTenantName(tenant.getTenantName());
                tenantResponseDto.setContact(tenant.getContact());
                tenantResponseDtoList.add(tenantResponseDto);
            }
        }
        return tenantResponseDtoList;
    }
    public TenantResponseDto tenantToTenantResponseDto(Tenant tenant){
        TenantResponseDto tenantResponseDto=new TenantResponseDto();
        tenantResponseDto.setTenantName(tenant.getTenantName());
        tenantResponseDto.setContact(tenant.getContact());
        return tenantResponseDto;
    }
}

