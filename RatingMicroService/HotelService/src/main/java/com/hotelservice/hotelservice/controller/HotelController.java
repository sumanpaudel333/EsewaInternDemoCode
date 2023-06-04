package com.hotelservice.hotelservice.controller;

import com.hotelservice.hotelservice.entity.Hotel;
import com.hotelservice.hotelservice.entity.Rating;
import com.hotelservice.hotelservice.service.HotelService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hotels")
@RequiredArgsConstructor
public class HotelController {
    private final HotelService hotelService;

    @PostMapping("/addnewhotel")
    public ResponseEntity<Hotel> addNewHotel(@RequestBody Hotel hotel) {
        Hotel hotel1 = hotelService.addHotel(hotel);
        return ResponseEntity.status(HttpStatus.CREATED).body(hotel1);
    }
    @GetMapping("/gethotels")
    public ResponseEntity<List<Hotel>> getAllHotels(){
        List<Hotel> hotels=hotelService.getAllHotels();
        return ResponseEntity.status(HttpStatus.FOUND).body(hotels);
    }
    @GetMapping("/gethotelbyid/{hotelId}")
    public Hotel getHotelById(@PathVariable String hotelId){
        return hotelService.getHotelById(hotelId);
    }
    @GetMapping("/getratingbyid/{hotelId}")
    public ResponseEntity<Hotel> getRatingByHotelId(@PathVariable String hotelId){
        Hotel hotelWithRating=hotelService.getRatingByHotelId(hotelId);
        return ResponseEntity.status(HttpStatus.FOUND).body(hotelWithRating);
    }
}
