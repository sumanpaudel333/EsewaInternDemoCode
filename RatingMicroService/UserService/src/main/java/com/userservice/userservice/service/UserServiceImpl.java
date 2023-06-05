package com.userservice.userservice.service;

import com.userservice.userservice.entity.Hotel;
import com.userservice.userservice.entity.Rating;
import com.userservice.userservice.entity.User;
import com.userservice.userservice.exception.ResourceNotFoundException;
import com.userservice.userservice.externalservice.HotelService;
import com.userservice.userservice.externalservice.RatingService;
import com.userservice.userservice.repo.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    //    private final RestTemplate restTemplate;
    private final RatingService ratingService;
    private final HotelService hotelService;

    @Override
    public User addUser(User user) {
        //generate unique userid
        String randomUserId = UUID.randomUUID().toString();
        user.setUserId(randomUserId);
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(String userId) {
        return userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User Not Found"));
    }

    @Override
    public User getUserByIdWithRating(String userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User Not Found!"));
//        List<Rating> rating = restTemplate.getForObject("http://RATING-SERVICE/api/rating/getratingbyuser/{userId}", List.class,userId);
        List<Rating> ratings = ratingService.listOfRatingByUserId(userId);
        List<Rating> ratings1 = new ArrayList<>();
        for (Rating rating : ratings) {
            Hotel hotel = hotelService.getHotelById(rating.getHotelId());
            rating.setHotel(hotel);
            ratings1.add(rating);
        }
        user.setRating(ratings1);
        return user;
    }
}
