package com.rms.rentalmanagementsystem.Landlord.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rms.rentalmanagementsystem.Landlord.dto.LandlordDto;
import com.rms.rentalmanagementsystem.Landlord.service.LandlordService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RentController {
    private final LandlordService landlordService;

    public RentController(LandlordService landlordService) {
        this.landlordService = landlordService;
    }

    @PostMapping("/")
    public LandlordDto addLandlord(@RequestBody LandlordDto landlordDto) {
        return landlordService.addLandlordDto(landlordDto);
    }
}
