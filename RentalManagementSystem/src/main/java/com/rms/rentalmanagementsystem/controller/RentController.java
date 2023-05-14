package com.rms.rentalmanagementsystem.controller;

import com.rms.rentalmanagementsystem.dto.LandlordDto;
import com.rms.rentalmanagementsystem.service.landlordservice.LandlordService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RentController {
    private final LandlordService landlordService;

    public RentController(LandlordService landlordService) {
        this.landlordService = landlordService;
    }

    @PostMapping(name = "/")
    public void addLandlord(@RequestBody LandlordDto landlordDto) {
        landlordService.addLandlordDto(landlordDto);
    }
}
