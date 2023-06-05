package com.userservice.userservice.externalservice;

import com.userservice.userservice.entity.Rating;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "RATING-SERVICE", path = "/api/rating")
public interface RatingService {
    @GetMapping("/getratingbyuser/{userId}")
    List<Rating> listOfRatingByUserId(@PathVariable String userId);

    @PostMapping("/addrating")
    Rating addRating(@RequestBody Rating rating);
}
