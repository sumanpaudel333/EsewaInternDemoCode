package com.rms.rentalmanagementsystem.Property.controller;

import com.rms.rentalmanagementsystem.Property.entity.Property;
import com.rms.rentalmanagementsystem.Property.service.PropertyService;
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
    public List<Property> getAllProperties() {
        return propertyService.getAllProperties();
    }
}
