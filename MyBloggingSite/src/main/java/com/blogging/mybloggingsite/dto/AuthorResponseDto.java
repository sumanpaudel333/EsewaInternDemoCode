package com.blogging.mybloggingsite.dto;

import jakarta.persistence.Column;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AuthorResponseDto {
    private String fullName;
    private String userName;
    private String email;
}
