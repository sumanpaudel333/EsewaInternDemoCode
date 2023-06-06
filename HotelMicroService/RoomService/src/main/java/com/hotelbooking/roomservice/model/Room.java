package com.hotelbooking.roomservice.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "room_id")
    private String roomId;
    @Column(name = "room_name")
    private String roomName;
    @Column(name = "room_status")
    private String roomStatus;
    @Column(name = "price")
    private String price;
    @Column(name = "room_image_url")
    private String roomImage;
}
