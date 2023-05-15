package com.rms.rentalmanagementsystem.Landlord.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rms.rentalmanagementsystem.Landlord.dto.LandlordDto;
import com.rms.rentalmanagementsystem.Landlord.entity.Landlord;
import com.rms.rentalmanagementsystem.Landlord.repo.LandlordRepo;
import com.rms.rentalmanagementsystem.Property.entity.Property;
import com.rms.rentalmanagementsystem.Property.enums.PropertyStatusEnum;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LandlordServiceImpl implements LandlordService {
    private final LandlordRepo landlordRepo;
    private final ObjectMapper objectMapper;

    public LandlordServiceImpl(LandlordRepo landlordRepo, ObjectMapper objectMapper) {
        this.landlordRepo = landlordRepo;
        this.objectMapper = objectMapper;
    }

    @Override
    public LandlordDto addLandlordDto(LandlordDto landlordDto) {
        Landlord landlord=objectMapper.convertValue(landlordDto, Landlord.class);
        List<Property> properties=landlord.getProperty();
        for (Property property:properties){
            property.setLandlord(landlord);
            property.setPropertyStatus(PropertyStatusEnum.Available);
        }
        landlordRepo.save(landlord);
        return objectMapper.convertValue(landlord, LandlordDto.class);
    }
}
