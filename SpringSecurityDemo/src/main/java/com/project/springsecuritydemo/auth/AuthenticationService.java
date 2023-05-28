package com.project.springsecuritydemo.auth;

import com.project.springsecuritydemo.entity.User;
import com.project.springsecuritydemo.repo.UserRepository;
import com.project.springsecuritydemo.service.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
public AuthenticationResponse register(RegisterRequest registerRequest){
   var user= User.builder()
           .userName(registerRequest.getUserName())
           .password(bCryptPasswordEncoder.encode(registerRequest.getPassword()))
           .email(registerRequest.getEmail())
           .role("ADMIN")
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
            authenticationRequest.getUserName(),
            authenticationRequest.getPassword()
    ));
    var user=userRepository.findByUserName(authenticationRequest.getUserName()).orElseThrow();
    var jwtToken=jwtService.generateToken(user);
    return AuthenticationResponse.builder()
            .token(jwtToken)
            .build();
}
}
