package com.rms.rentalmanagementsystem.auth.service;

import com.rms.rentalmanagementsystem.auth.config.AuthenticationRequest;
import com.rms.rentalmanagementsystem.auth.config.AuthenticationResponse;
import com.rms.rentalmanagementsystem.auth.config.RegisterRequest;
import com.rms.rentalmanagementsystem.auth.model.Role;
import com.rms.rentalmanagementsystem.auth.model.User;
import com.rms.rentalmanagementsystem.auth.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserRepo userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    public AuthenticationResponse register(RegisterRequest registerRequest){
        var user= User.builder()
                .userName(registerRequest.getUserName())
                .password(bCryptPasswordEncoder.encode(registerRequest.getPassword()))
                .email(registerRequest.getEmail())
                .role(Role.valueOf(registerRequest.getRole()))
                .build();
        userRepository.save(user);
        var jwtToken=jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }
    public AuthenticationResponse authenticate(AuthenticationRequest authenticationRequest){
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authenticationRequest.getUsername(),
                        authenticationRequest.getPassword()
                ));
        var user=userRepository.findByUserName(authenticationRequest.getUsername());
        var jwtToken=jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }
}
