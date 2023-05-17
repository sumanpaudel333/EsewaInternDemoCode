package com.rms.rentalmanagementsystem.service;

import com.rms.rentalmanagementsystem.dto.PropertyDto;
import com.rms.rentalmanagementsystem.entity.Property;
import com.rms.rentalmanagementsystem.repo.PropertyRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PropertyServiceImpl implements PropertyService {
    private final PropertyRepo propertyRepo;

    public PropertyServiceImpl(PropertyRepo propertyRepo) {
        this.propertyRepo = propertyRepo;
    }

    @Override
    public List<PropertyDto> getAllProperties() {
        List<Property> property = propertyRepo.findAll();
        List<PropertyDto>propertyDtoList = new ArrayList<>();
        for (Property property1 : property) {
            PropertyDto propertyDto = new PropertyDto();
            propertyDto.setLandlord_id(property1.getLandlord().getId());
            propertyDto.setPropertyStatus(property1.getPropertyStatus());
            propertyDto.setPropertyType(property1.getPropertyType());
            propertyDto.setRentAmount(property1.getRentAmount());
            propertyDto.setAddress(property1.getAddress());
            propertyDtoList.add(propertyDto);
        }
        return propertyDtoList;
    }
}
