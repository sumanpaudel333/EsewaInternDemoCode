package com.ratingservice.ratingservice.controller;

import com.ratingservice.ratingservice.entity.Rating;
import com.ratingservice.ratingservice.service.RatingService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/rating")
public class RatingController {
    private final RatingService ratingService;
    @PostMapping("/addrating")
    public ResponseEntity<Rating> addRating(@RequestBody Rating rating){
        return ResponseEntity.status(HttpStatus.CREATED).body(ratingService.addRating(rating));
    }
    @GetMapping("/getallratings")
    public ResponseEntity<List<Rating>> getAllRating(){
        return ResponseEntity.status(HttpStatus.FOUND).body(ratingService.getAllRatings());
    }
    @GetMapping("/getratingbyuser/{userId}")
    public List<Rating> listOfRatingByUserId(@PathVariable String userId){
        return ratingService.getRatingByUserId(userId);
    }
    @GetMapping("/getratingbyhotel/{hotelId}")
    public List<Rating> listOfRatingByHotelId(@PathVariable String hotelId){
        return ratingService.getRatingByHotel(hotelId);
    }
}
