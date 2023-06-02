package com.hotelservice.hotelservice.service;

import com.hotelservice.hotelservice.entity.Hotel;
import com.hotelservice.hotelservice.entity.Rating;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface HotelService {
    Hotel addHotel(Hotel hotel);
    List<Hotel> getAllHotels();
    Hotel getHotelById(String hotelId);
    List<Rating> getRatingByHotelId(String hotelId);

}
