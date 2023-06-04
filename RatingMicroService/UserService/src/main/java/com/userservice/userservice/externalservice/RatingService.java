package com.userservice.userservice.externalservice;

import com.userservice.userservice.entity.Rating;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "RATING-SERVICE",path = "/api/rating")
public interface RatingService {
    @GetMapping("/getratingbyuser/{userId}")
   List<Rating> listOfRatingByUserId(@PathVariable String userId);
}
