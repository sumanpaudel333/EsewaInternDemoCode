package com.ratingservice.ratingservice.entity;

import lombok.*;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document("rating-service")
@Builder
public class Rating {
    private String ratingId;
    private String userId;
    private String hotelId;
    private int rating;
    private String feedback;
    @Transient
    private Hotel hotel;
    @Transient
    private User user;
}
