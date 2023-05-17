package com.rms.rentalmanagementsystem.service;

import com.rms.rentalmanagementsystem.dto.PropertyDto;
import com.rms.rentalmanagementsystem.entity.Property;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PropertyService {
List<PropertyDto> getAllProperties();
}
