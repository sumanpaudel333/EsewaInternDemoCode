package com.rms.rentalmanagementsystem.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rms.rentalmanagementsystem.dto.LandlordRequestDto;
import com.rms.rentalmanagementsystem.dto.LandlordResponseDto;
import com.rms.rentalmanagementsystem.entity.Contact;
import com.rms.rentalmanagementsystem.entity.Landlord;
import com.rms.rentalmanagementsystem.entity.Property;
import com.rms.rentalmanagementsystem.enums.PropertyStatusEnum;
import com.rms.rentalmanagementsystem.enums.UserStatusEnum;
import com.rms.rentalmanagementsystem.exception.UserNotFoundException;
import com.rms.rentalmanagementsystem.repo.ContactRepo;
import com.rms.rentalmanagementsystem.repo.LandlordRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class LandlordServiceImpl implements LandlordService {
    private final LandlordRepo landlordRepo;
    private final PropertyServiceImpl propertyService;
    private final ContactRepo contactRepo;
    private final ObjectMapper objectMapper;

    public LandlordServiceImpl(LandlordRepo landlordRepo, PropertyServiceImpl propertyService, ContactRepo contactRepo, ObjectMapper objectMapper) {
        this.landlordRepo = landlordRepo;
        this.propertyService = propertyService;
        this.contactRepo = contactRepo;
        this.objectMapper = objectMapper;
    }

    @Override
    public void addLandlordDto(LandlordRequestDto landlordRequestDto) {
        Landlord landlord = objectMapper.convertValue(landlordRequestDto, Landlord.class);
        List<Property> properties = landlordRequestDto.getProperty();
        landlord.setUserStatus(UserStatusEnum.Active);
        for (Property property : properties) {
            property.setLandlord(landlord);
            property.setPropertyStatus(PropertyStatusEnum.Available);
        }
        landlord.setProperty(properties);
        landlordRepo.save(landlord);
    }

    public List<LandlordResponseDto> getAllLandlord() {
        List<Landlord> landlords = landlordRepo.findAll();
        if (landlords.isEmpty())
            throw new UserNotFoundException("No landlord found");
        List<LandlordResponseDto> landlordResponseDtoList = new ArrayList<>();
        for (Landlord landlord : landlords) {
            if (landlord.getUserStatus().equals(UserStatusEnum.Active) || landlord.getUserStatus().equals(UserStatusEnum.Inactive)) {
                LandlordResponseDto landlordResponseDto = new LandlordResponseDto();
                landlordResponseDto.setId(landlord.getId());
                landlordResponseDto.setNo_of_properties(landlord.getProperty().size());
                landlordResponseDto.setContact(landlord.getContact());
                landlordResponseDto.setName(landlord.getName());
                landlordResponseDto.setAccountNumber(landlord.getAccountNumber());
                landlordResponseDtoList.add(landlordResponseDto);
            }
        }
        return landlordResponseDtoList;
    }

    public LandlordResponseDto getLandlordById(int id) {
        Optional<Landlord> landlord = landlordRepo.findById(id);
        LandlordResponseDto landlordResponseDto = new LandlordResponseDto();
        if (landlord.isPresent() && landlord.get().getUserStatus().equals(UserStatusEnum.Active)) {
            landlordResponseDto.setName(landlord.get().getName());
            landlordResponseDto.setContact(landlord.get().getContact());
            landlordResponseDto.setAccountNumber(landlord.get().getAccountNumber());
            landlordResponseDto.setNo_of_properties(landlord.get().getProperty().size());
            landlordResponseDto.setId(landlord.get().getId());
            return landlordResponseDto;
        } else
            throw new UserNotFoundException("Landlord Not Found with given id");
    }

    public void updateLandlordById(int id, LandlordRequestDto landlordRequestDto) {
        Landlord landlord = new Landlord();
        Contact contact = new Contact();
        landlord.setId(id);
        landlord.setName(landlordRequestDto.getName());
        contact.setId(landlordRequestDto.getContact().getId());
        contact.setAddress(landlordRequestDto.getContact().getAddress());
        contact.setEmail(landlordRequestDto.getContact().getEmail());
        contact.setPhone(landlordRequestDto.getContact().getPhone());
        landlord.setContact(contact);
        landlord.setAccountNumber(landlordRequestDto.getAccountNumber());
        landlordRepo.save(landlord);
        contactRepo.deleteById(id);
    }

    public void deleteLandlordById(int id) {
        Landlord landlord = landlordRepo.findById(id).orElseThrow();
        landlord.setUserStatus(UserStatusEnum.Deleted);
        contactRepo.save(landlord.getContact());
        landlordRepo.save(landlord);
    }
}
