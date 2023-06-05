package com.ratingservice.ratingservice.service;

import com.ratingservice.ratingservice.entity.Hotel;
import com.ratingservice.ratingservice.entity.Rating;
import com.ratingservice.ratingservice.entity.User;
import com.ratingservice.ratingservice.externalservice.HotelService;
import com.ratingservice.ratingservice.externalservice.UserService;
import com.ratingservice.ratingservice.repo.RatingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RatingServiceImpl implements RatingService {
    private final RatingRepository ratingRepository;
    private final HotelService hotelService;
    private final UserService userService;

    @Override
    public Rating addRating(Rating rating) {
        String ratingId = UUID.randomUUID().toString();
        rating.setRatingId(ratingId);
        return ratingRepository.save(rating);
    }

    @Override
    public List<Rating> getAllRatings() {
        return ratingRepository.findAll();
    }

    @Override
    public List<Rating> getRatingByUserId(String userId) {
        List<Rating> ratings = ratingRepository.findByUserId(userId);
        List<Rating> ratings1 = new ArrayList<>();
        for (Rating rating : ratings) {
            User user = userService.getUserById(rating.getUserId());
            Hotel hotel = hotelService.getHotelById(rating.getHotelId());
            Rating rating1 = Rating.builder()
                    .userId(rating.getUserId())
                    .ratingId(rating.getRatingId())
                    .rating(rating.getRating())
                    .feedback(rating.getFeedback())
                    .hotelId(rating.getHotelId())
                    .hotel(hotel)
                    .user(user)
                    .build();
            ratings1.add(rating1);
        }
        return ratings1;
    }

    @Override
    public List<Rating> getRatingByHotel(String hotelId) {
        return ratingRepository.findByHotelId(hotelId);
    }

}
