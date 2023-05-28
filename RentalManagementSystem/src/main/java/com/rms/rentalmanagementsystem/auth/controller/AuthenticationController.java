package com.rms.rentalmanagementsystem.auth.controller;

import com.rms.rentalmanagementsystem.auth.config.AuthenticationRequest;
import com.rms.rentalmanagementsystem.auth.config.AuthenticationResponse;
import com.rms.rentalmanagementsystem.auth.config.RegisterRequest;
import com.rms.rentalmanagementsystem.auth.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

    @RestController
    @RequiredArgsConstructor
    @RequestMapping(value = "/auth")
    public class AuthenticationController {
        private final AuthenticationService authenticationService;
        @PostMapping(value = "/register")
        public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequest registerRequest){
            return ResponseEntity.ok(authenticationService.register(registerRequest));
        }
        @PostMapping(value = "/authenticate")
        public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest registerRequest){
            return ResponseEntity.ok(authenticationService.authenticate(registerRequest));
        }
    }

