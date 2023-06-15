package com.blogging.mybloggingsite.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AuthorRequestDto {
    private String email;
    private String userName;
    private String password;
    private String fullName;
}
