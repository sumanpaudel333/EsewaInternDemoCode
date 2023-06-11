package com.blogging.mybloggingsite.config;

import com.blogging.mybloggingsite.repo.AuthorRepository;
import com.blogging.mybloggingsite.service.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
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
    UserDetails userDetails= User.withUsername(user.getUserName()).password(user.getPassword()).authorities("Admin").build();
    var jwtToken=jwtService.generateToken(userDetails);
    return AuthenticationResponse.builder()
            .token(jwtToken)
            .build();
}
}
