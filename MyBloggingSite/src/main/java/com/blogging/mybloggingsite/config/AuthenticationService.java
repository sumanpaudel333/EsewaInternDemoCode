package com.blogging.mybloggingsite.config;

import com.blogging.mybloggingsite.repo.AuthorRepository;
import com.blogging.mybloggingsite.service.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final AuthorRepository authorRepository;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
public AuthenticationResponse authenticate(AuthenticationRequest authenticationRequest){
    authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(
            authenticationRequest.getUsername(),
            authenticationRequest.getPassword()
    ));
    var user=authorRepository.findByUserName(authenticationRequest.getUsername()).orElseThrow();
    var jwtToken=jwtService.generateToken(user);
    return AuthenticationResponse.builder()
            .token(jwtToken)
            .build();
}
}
