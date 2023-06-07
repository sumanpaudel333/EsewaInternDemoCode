package com.bookingservice.bookingservice.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "booking_id")
    private String bookingId;
    private Date bookedDate;
    private Date checkInDate;
    private Date checkOutDate;
    private String roomNo;
    private String bookedBy;
}
