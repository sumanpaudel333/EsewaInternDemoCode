package com.rms.rentalmanagementsystem.Property.service;

import com.rms.rentalmanagementsystem.Property.entity.Property;
import com.rms.rentalmanagementsystem.Property.repo.PropertyRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PropertyServiceImpl implements PropertyService {
    private final PropertyRepo propertyRepo;

    public PropertyServiceImpl(PropertyRepo propertyRepo) {
        this.propertyRepo = propertyRepo;
    }

    @Override
    public List<Property> getAllProperties() {
        return propertyRepo.findAll();
    }
}
