package com.microservice.employeeservice.feign;

import com.microservice.employeeservice.dto.AddressResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "address",url = "http://localhost:8081/")
public interface AddressClient {
    @GetMapping("/address/{id}")
    AddressResponse getAddressByEmployeeId(@PathVariable("id") int id);
    @GetMapping("/getalladdress")
    ResponseEntity<List<AddressResponse>> getAllAddress();
}
