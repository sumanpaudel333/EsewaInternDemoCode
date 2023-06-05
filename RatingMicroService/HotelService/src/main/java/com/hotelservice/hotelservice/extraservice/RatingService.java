package com.hotelservice.hotelservice.extraservice;

import com.hotelservice.hotelservice.entity.Rating;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(value = "RATING-SERVICE",path = "/api/rating/")
public interface RatingService {
    @GetMapping("/getratingbyhotel/{hotelId}")
    List<Rating> listOfRatingByHotelId(@PathVariable String hotelId);
}
