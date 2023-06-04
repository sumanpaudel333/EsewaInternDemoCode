package com.userservice.userservice.service;

import com.userservice.userservice.entity.Rating;
import com.userservice.userservice.entity.User;
import com.userservice.userservice.exception.ResourceNotFoundException;
import com.userservice.userservice.externalservice.RatingService;
import com.userservice.userservice.repo.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
//    private final RestTemplate restTemplate;
    private final RatingService ratingService;

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
        return userRepository.findById(userId).orElseThrow(()->new ResourceNotFoundException("User Not Found"));
    }

    @Override
    public User getUserByIdWithRating(String userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User Not Found!"));
//        List<Rating> rating = restTemplate.getForObject("http://RATING-SERVICE/api/rating/getratingbyuser/{userId}", List.class,userId);
        List<Rating> ratings=ratingService.listOfRatingByUserId(userId);
        user.setRating(ratings);
        return user;
    }

}
