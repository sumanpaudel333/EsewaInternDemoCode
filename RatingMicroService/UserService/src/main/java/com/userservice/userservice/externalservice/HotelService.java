package com.userservice.userservice.externalservice;

import com.userservice.userservice.entity.Hotel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "HOTEL-SERVICE", path = "/api/hotels")
public interface HotelService {
    @GetMapping("/gethotelbyid/{hotelId}")
    Hotel getHotelById(@PathVariable String hotelId);
}
