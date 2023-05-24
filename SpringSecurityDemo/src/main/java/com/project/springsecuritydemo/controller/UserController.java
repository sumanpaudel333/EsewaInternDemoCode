package com.project.springsecuritydemo.controller;

import com.project.springsecuritydemo.config.ApplicationConfig;
import com.project.springsecuritydemo.entity.User;
import com.project.springsecuritydemo.repo.UserRepository;
import com.project.springsecuritydemo.service.JpaUserDetailService;
import com.project.springsecuritydemo.service.JwtService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;
    private final JpaUserDetailService jpaUserDetailService;
    private final JwtService jwtService;

    public UserController(UserRepository userRepository, AuthenticationManager authenticationManager, JpaUserDetailService jpaUserDetailService, JwtService jwtService) {
        this.userRepository = userRepository;
        this.authenticationManager = authenticationManager;
        this.jpaUserDetailService = jpaUserDetailService;
        this.jwtService = jwtService;
    }

    @GetMapping(value = "/greetuser")
    public String user() {
        return "Hello User";
    }

    @PostMapping(value = "/adduser")
    public String addUser(@RequestBody User user) {
        String pass = ApplicationConfig.bCryptPasswordEncoder().encode(user.getPassword());
        user.setPassword(pass);
        userRepository.save(user);
        return "User Added Successfully";
    }

    @GetMapping(value = "/getuser")
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @PostMapping(value = "/authenticate")
    public String authenticate(@RequestBody User user) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
        final UserDetails userDetails = jpaUserDetailService.loadUserByUsername(user.getUsername());
        return jwtService.generateToken(userDetails);
    }
}
