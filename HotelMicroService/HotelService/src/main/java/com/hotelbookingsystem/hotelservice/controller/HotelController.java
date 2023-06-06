package com.hotelbookingsystem.hotelservice.controller;

import com.hotelbookingsystem.hotelservice.model.Hotel;
import com.hotelbookingsystem.hotelservice.service.HotelService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hotel")
@RequiredArgsConstructor
public class HotelController {
    private final HotelService hotelService;

    @PostMapping("/add")
    public Hotel addNewHotel(@RequestBody Hotel hotel) {
        hotelService.addHotel(hotel);
        return hotel;
    }

    @GetMapping("/getallhotels")
    public List<Hotel> hotelList() {
    return hotelService.getAllHotel();
    }

    @GetMapping("/gethotelbyid/{hotelId}")
    public Hotel getHotelById(@PathVariable String hotelId){
        return hotelService.getHotelById(hotelId);
    }
}
