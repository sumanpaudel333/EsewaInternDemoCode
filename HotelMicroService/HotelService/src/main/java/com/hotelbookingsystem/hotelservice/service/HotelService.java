package com.hotelbookingsystem.hotelservice.service;

import com.hotelbookingsystem.hotelservice.model.Hotel;
import org.springframework.stereotype.Service;

import java.util.List;


public interface HotelService {
    Hotel addHotel(Hotel hotel);
    List<Hotel> getAllHotel();
    Hotel getHotelById(String hotelId);
}
