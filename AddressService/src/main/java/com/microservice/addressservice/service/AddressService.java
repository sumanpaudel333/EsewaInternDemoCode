package com.microservice.addressservice.service;

import com.microservice.addressservice.dto.AddressResponse;
import com.microservice.addressservice.entity.Address;
import com.microservice.addressservice.repo.AddressRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AddressService {
    private final AddressRepository addressRepository;
    private final ModelMapper modelMapper;

    public AddressResponse getAddressByEmployeeId(int id) {
        Address address = addressRepository.findEmployeeByAddressId(id);
        return modelMapper.map(address, AddressResponse.class);
    }
}
