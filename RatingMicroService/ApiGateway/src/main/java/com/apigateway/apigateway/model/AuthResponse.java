package com.apigateway.apigateway.model;

import lombok.*;

import java.util.Collection;
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AuthResponse {
    private String userId;
    private String accessToken;
    private String refreshToken;
    private long expiredAt;
    private Collection<String> authorities;
}
