package com.hotelbooking.roomservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Booking {
    private String bookingId;
    private Date bookedDate;
    private Date checkInDate;
    private Date checkOutDate;
    private String roomNo;
    private String bookedBy;
}
