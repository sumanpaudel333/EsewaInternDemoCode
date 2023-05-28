package com.rms.rentalmanagementsystem.controller;

import com.rms.rentalmanagementsystem.dto.LandlordRequestDto;
import com.rms.rentalmanagementsystem.dto.LandlordResponseDto;
import com.rms.rentalmanagementsystem.service.LandlordService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/landlord")
public class LandlordController {
    private final LandlordService landlordService;

    public LandlordController(LandlordService landlordService) {
        this.landlordService = landlordService;
    }

    @PostMapping("/addlandlord")
    public String addLandlord(@RequestBody LandlordRequestDto landlordRequestDto) {
         landlordService.addLandlordDto(landlordRequestDto);
         return "User Added Successfully!";
    }
    @GetMapping(value = "/getalllandlord")
    public List<LandlordResponseDto> getAllLandlord() {
        return landlordService.getAllLandlord();
    }
    @GetMapping(value = "/getlandlord/{id}")
    public LandlordResponseDto getAllLandlord(@PathVariable int id) {
        return landlordService.getLandlordById(id);
    }
    @PutMapping(value = "/update/{id}")
    public String updateLandlordById(@PathVariable("id") int id,@RequestBody LandlordRequestDto landlordRequestDto){
        landlordService.updateLandlordById(id,landlordRequestDto);
        return "User Updated Successfully";
    }
    @PostMapping("/delete/{id}")
    public String deleteLandlordById(@PathVariable("id") int id){
        landlordService.deleteLandlordById(id);
        return "User Deleted Successfully";
    }
}
