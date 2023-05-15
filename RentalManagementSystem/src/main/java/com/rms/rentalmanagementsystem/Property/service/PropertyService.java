package com.rms.rentalmanagementsystem.Property.service;

import com.rms.rentalmanagementsystem.Property.entity.Property;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PropertyService {
List<Property> getAllProperties();
}
