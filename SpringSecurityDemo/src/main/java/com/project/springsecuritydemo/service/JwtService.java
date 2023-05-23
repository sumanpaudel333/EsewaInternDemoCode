package com.project.springsecuritydemo.service;

import io.jsonwebtoken.Claims;
import org.springframework.stereotype.Service;

@Service
public class JwtService {
    public String extractUsername(String token){
        return null;
    }
    private Claims claims(String token){
        return null;
    }
}
