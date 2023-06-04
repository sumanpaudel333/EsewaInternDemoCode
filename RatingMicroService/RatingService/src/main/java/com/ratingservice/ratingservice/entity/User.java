package com.ratingservice.ratingservice.entity;

import lombok.*;
import org.springframework.data.annotation.Transient;

import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    private String userId;
    private String name;
    private String email;
    private String about;
}
