package com.bookingservice.bookingservice.service;

import com.bookingservice.bookingservice.model.Booking;
import com.bookingservice.bookingservice.repo.BookingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService{
    private final BookingRepository bookingRepository;
    @Override
    public String bookRoom(String roomId,Booking booking) {
        bookingRepository.save(booking);
        return "Room Booked Successfully!";
    }
}
