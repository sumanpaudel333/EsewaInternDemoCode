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
@GetMapping("/getuser/{userId}")
public ResponseEntity<User> getUserById(@PathVariable String userId){
    User user= userService.getUserById(userId);
    return ResponseEntity.ok(user);
}
@GetMapping("/getalluser")
    public ResponseEntity<List<User>> getAllUser(){
    List<User> userList=userService.getAllUser();
    return ResponseEntity.status(HttpStatus.FOUND).body(userList);
}
}
