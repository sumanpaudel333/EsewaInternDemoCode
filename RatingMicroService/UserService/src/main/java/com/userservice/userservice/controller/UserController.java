package com.userservice.userservice.controller;

import com.userservice.userservice.entity.User;
import com.userservice.userservice.service.UserService;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {
private final UserService userService;
@PostMapping("/adduser")
public ResponseEntity<User> addUser(@RequestBody User user){
    User user1=userService.addUser(user);
    return ResponseEntity.status(HttpStatus.CREATED).body(user1);
}
    int retryCount=1;
@GetMapping("/getuserwithrating/{userId}")
//@CircuitBreaker(name = "ratingBreaker",fallbackMethod = "ratingFallBack")
@Retry(name = "ratingBreaker",fallbackMethod = "ratingFallBack")
public User getUserByIdWithRating(@PathVariable String userId){
    retryCount++;
    System.out.println("Retry Count: "+retryCount);
    return userService.getUserByIdWithRating(userId);
}

@GetMapping("/getuser/{userId}")
public User getUserById(@PathVariable String userId){
    return userService.getUserById(userId);
}
@GetMapping("/getalluser")
    public ResponseEntity<List<User>> getAllUser(){
    List<User> userList=userService.getAllUser();
    return ResponseEntity.status(HttpStatus.FOUND).body(userList);
}
// fallback method for circuit breaker
    User ratingFallBack(String userId,Exception exception){
        return User.builder()
                .name("Dummy User")
                .email("dummy@gmail.com")
                .about("This is dummy user created for fallback.")
                .build();
    }
}
