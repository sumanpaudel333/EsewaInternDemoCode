package com.userservice.userservice.controller;

import com.userservice.userservice.entity.User;
import com.userservice.userservice.service.UserService;
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
@GetMapping("/getuserwithrating/{userId}")
public User getUserByIdWithRating(@PathVariable String userId){
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
}
