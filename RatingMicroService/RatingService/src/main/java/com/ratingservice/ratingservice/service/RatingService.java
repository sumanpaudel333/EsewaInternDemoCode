package com.ratingservice.ratingservice.service;

import com.ratingservice.ratingservice.entity.Rating;

import java.util.List;

public interface RatingService {
    Rating addRating(Rating rating);
    List<Rating> getAllRatings();
    List<Rating> getRatingByUserId(String userId);
    List<Rating> getRatingByHotel(String hotelId);
}
