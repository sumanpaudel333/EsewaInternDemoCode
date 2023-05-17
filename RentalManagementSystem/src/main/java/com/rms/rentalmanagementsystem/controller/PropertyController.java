package com.rms.rentalmanagementsystem.controller;

import com.rms.rentalmanagementsystem.dto.PropertyDto;
import com.rms.rentalmanagementsystem.entity.Property;
import com.rms.rentalmanagementsystem.service.PropertyService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PropertyController {
    private final PropertyService propertyService;

    public PropertyController(PropertyService propertyService) {
        this.propertyService = propertyService;
    }
    @GetMapping(value = "/getallproperty")
    public List<PropertyDto> getAllProperties() {
        return propertyService.getAllProperties();
    }
}
