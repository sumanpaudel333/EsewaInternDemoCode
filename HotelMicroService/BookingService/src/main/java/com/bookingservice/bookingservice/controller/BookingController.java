package com.bookingservice.bookingservice.controller;

import com.bookingservice.bookingservice.model.Booking;
import com.bookingservice.bookingservice.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/booking")
public class BookingController {
    private final BookingService bookingService;
    @PostMapping("/book")
    String bookRoom(@RequestBody Booking booking){
        return bookingService.bookRoom(booking);
    }
}
