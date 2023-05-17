package com.rms.rentalmanagementsystem.service;

import com.rms.rentalmanagementsystem.dto.LandlordRequestDto;
import com.rms.rentalmanagementsystem.dto.LandlordResponseDto;
import com.rms.rentalmanagementsystem.dto.PropertyDto;
import com.rms.rentalmanagementsystem.entity.Landlord;

import java.util.List;

public interface LandlordService {
   void addLandlordDto(LandlordRequestDto landlordRequestDto);

    List<LandlordResponseDto> getAllLandlord();

    LandlordResponseDto getLandlordById(int id);

    void updateLandlordById(int id, LandlordRequestDto landlordRequestDto);

    void deleteLandlordById(int id);
}
