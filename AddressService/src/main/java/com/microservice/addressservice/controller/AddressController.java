package com.microservice.addressservice.controller;

import com.microservice.addressservice.dto.AddressResponse;
import com.microservice.addressservice.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class AddressController {
    private final AddressService addressService;

    @GetMapping("/address/{id}")
    public ResponseEntity<AddressResponse> getAddressByEmployeeId(@PathVariable("id") int employeeId) {
        AddressResponse address = addressService.getAddressByEmployeeId(employeeId);
        return ResponseEntity.status(HttpStatus.OK).body(address);
    }
    @GetMapping("/address/getalladdress")
    public ResponseEntity<List<AddressResponse>> getAllAddress() {
        List<AddressResponse> address = addressService.getAllAddress();
        return ResponseEntity.status(HttpStatus.OK).body(address);
    }
    @PostMapping("/address/addaddress")
    public String addNewAddress(@RequestBody AddressResponse addressResponse) {
        return addressService.addAddress(addressResponse);
    }
}
