package com.project.springsecuritydemo.controller;

import com.project.springsecuritydemo.config.SecurityConfiguration;
import com.project.springsecuritydemo.entity.User;
import com.project.springsecuritydemo.repo.UserRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping(value = "/greetuser")
    public String user() {
        return "Hello User";
    }
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping(value = "/adduser")
    public String addUser(@RequestBody User user){
        String pass=SecurityConfiguration.bCryptPasswordEncoder().encode(user.getPassword());
        user.setPassword(pass);
        userRepository.save(user);
        return "User Added Successfully";
    }
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping(value = "/getuser")
    public List<User> getAllUser(){
        return userRepository.findAll();
    }
}
