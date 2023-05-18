package com.rms.rentalmanagementsystem.service;

import com.rms.rentalmanagementsystem.dto.TenantRequestDto;
import com.rms.rentalmanagementsystem.dto.TenantResponseDto;
import com.rms.rentalmanagementsystem.entity.Contact;
import com.rms.rentalmanagementsystem.entity.Tenant;
import com.rms.rentalmanagementsystem.enums.UserStatusEnum;
import com.rms.rentalmanagementsystem.exception.UserNotFoundException;
import com.rms.rentalmanagementsystem.repo.TenantRepository;
import com.rms.rentalmanagementsystem.resources.ConvertToDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TenantServiceImpl implements TenantService {
    private final TenantRepository tenantRepository;

    public TenantServiceImpl(TenantRepository tenantRepository) {
        this.tenantRepository = tenantRepository;
    }

    @Override
    public void addTenantDto(TenantRequestDto tenantRequestDto) {
        ConvertToDto toDto = new ConvertToDto();
        Tenant tenant = toDto.tenantRequestDtoToTenant(tenantRequestDto);
        tenantRepository.save(tenant);
    }

    @Override
    public List<TenantResponseDto> getAllTenant() {
        List<Tenant> tenant = tenantRepository.findAll();
        ConvertToDto convertToDto = new ConvertToDto();
        List<TenantResponseDto> tenantResponseDtoList = convertToDto.listOfTenantToResponseList(tenant);
        if (tenantResponseDtoList.isEmpty())
            throw new UserNotFoundException("No User Found for tenant");
        return tenantResponseDtoList;
    }

    @Override
    public TenantResponseDto getTenantById(int id) {
        Tenant tenant = tenantRepository.findById(id).orElseThrow();
        ConvertToDto convertToDto = new ConvertToDto();
        return convertToDto.tenantToTenantResponseDto(tenant);
    }

    @Override
    public void updateTenantById(int id, TenantRequestDto tenantRequestDto) {
        Contact contact=new Contact();
        Tenant tenant=tenantRepository.findById(id).orElseThrow();
        contact.setId(tenant.getContact().getId());
        contact.setAddress(tenantRequestDto.getContact().getAddress());
        contact.setPhone(tenantRequestDto.getContact().getPhone());
        contact.setEmail(tenantRequestDto.getContact().getEmail());
        tenant.setTenantName(tenantRequestDto.getTenantName());
        tenant.setContact(contact);
        tenantRepository.save(tenant);
    }

    @Override
    public void deleteTenantById(int id) {
        Tenant tenant = tenantRepository.findById(id).orElseThrow(RuntimeException::new);
        tenant.setTenantStatus(UserStatusEnum.Deleted);
        tenantRepository.save(tenant);
    }
}
