package com.rms.rentalmanagementsystem.service.landlordservice;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rms.rentalmanagementsystem.dto.LandlordDto;
import com.rms.rentalmanagementsystem.entity.Landlord;
import com.rms.rentalmanagementsystem.repo.LandlordRepo;
import org.springframework.stereotype.Service;

@Service
public class LandlordServiceImpl implements LandlordService{
    private final LandlordRepo landlordRepo;
    private final ObjectMapper objectMapper;
    public LandlordServiceImpl(LandlordRepo landlordRepo, ObjectMapper objectMapper) {
        this.landlordRepo = landlordRepo;
        this.objectMapper = objectMapper;
    }

    @Override
    public LandlordDto addLandlordDto(LandlordDto landlordDto) {
        LandlordDto landlordDto1=new LandlordDto();
       Landlord landlord=landlordRepo.save(objectMapper.convertValue(landlordDto, Landlord.class));
        return objectMapper.convertValue(landlord, LandlordDto.class);
    }
}
