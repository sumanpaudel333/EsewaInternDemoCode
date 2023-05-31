package com.microservice.employeeservice.feign;

import com.microservice.employeeservice.dto.AddressResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@FeignClient(name = "Address-Service",path = "/address/")
public interface AddressClient {
    @GetMapping("{id}")
    AddressResponse getAddressByEmployeeId(@PathVariable("id") int id);
    @GetMapping("getalladdress")
    ResponseEntity<List<AddressResponse>> getAllAddress();
    @PostMapping("addaddress")
    String addNewAddress(AddressResponse addressResponse);
}
