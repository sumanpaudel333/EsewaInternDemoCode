package com.microservice.addressservice.service;

import com.microservice.addressservice.dto.AddressResponse;
import com.microservice.addressservice.entity.Address;
import com.microservice.addressservice.repo.AddressRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressService {
    private final AddressRepository addressRepository;
    private final ModelMapper modelMapper;

    public AddressResponse getAddressByEmployeeId(int id) {
        Address address = addressRepository.findEmployeeByAddressId(id);
        return modelMapper.map(address, AddressResponse.class);
    }
    public List<AddressResponse> getAllAddress(){
        List<Address> address=addressRepository.findAll();
        List<AddressResponse> addressResponses=new ArrayList<>();
        for (Address addressResponse:address){
            AddressResponse addressResponse1=new AddressResponse();
            addressResponse1.setId(addressResponse.getId());
            addressResponse1.setCity(addressResponse.getCity());
            addressResponse1.setStreet(addressResponse.getStreet());
            addressResponse1.setState(addressResponse.getState());
            addressResponses.add(addressResponse1);
        }
        return addressResponses;
    }
}
