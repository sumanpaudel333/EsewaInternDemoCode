package com.hotelservice.hotelservice.service;

import com.hotelservice.hotelservice.entity.Hotel;
import com.hotelservice.hotelservice.entity.Rating;
import com.hotelservice.hotelservice.exception.ResourceNotFoundException;
import com.hotelservice.hotelservice.extraservice.RatingService;
import com.hotelservice.hotelservice.repo.HotelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class HotelServiceImpl implements HotelService{
    private final HotelRepository hotelRepository;
    private final RestTemplate restTemplate;
    private final RatingService ratingService;
    @Override
    public Hotel addHotel(Hotel hotel) {
        String hotelId= UUID.randomUUID().toString();
        hotel.setHotelId(hotelId);
        return hotelRepository.save(hotel);
    }

    @Override
    public List<Hotel> getAllHotels() {
        return hotelRepository.findAll();
    }

    @Override
    public Hotel getHotelById(String hotelId) {
        return hotelRepository.findById(hotelId).orElseThrow(()->new ResourceNotFoundException("Hotel Not Found in List"));
    }
    @Override
    public Hotel getRatingByHotelId(String hotelId) {
        Hotel hotel = hotelRepository.findById(hotelId).orElseThrow(() -> new ResourceNotFoundException("User Not Found!"));
        List<Rating> rating = ratingService.listOfRatingByHotelId(hotelId).getBody();
        hotel.setRatings(rating);
        return hotel;
    }
}
