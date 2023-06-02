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
@RequestMapping("/hotels")
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
    public ResponseEntity<Hotel> getHotelById(@PathVariable String hotelId){
        Hotel hotel=hotelService.getHotelById(hotelId);
        return ResponseEntity.status(HttpStatus.FOUND).body(hotel);
    }
    @GetMapping("/getratingbyid/{hotelId}")
    public ResponseEntity<List<Rating>> getRatingByHotelId(@PathVariable String hotelId){
        List<Rating> ratings=hotelService.getRatingByHotelId(hotelId);
        return ResponseEntity.status(HttpStatus.FOUND).body(ratings);
    }
}
