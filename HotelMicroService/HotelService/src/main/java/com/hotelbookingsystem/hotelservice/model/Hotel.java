package com.hotelbookingsystem.hotelservice.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "hotel_id")
    private String hotelId;
    @Column(name = "hotel_name")
    private String hotelName;
    @Column(name = "location")
    private String location;
    @Column(name = "contact")
    private String Contact;
}
