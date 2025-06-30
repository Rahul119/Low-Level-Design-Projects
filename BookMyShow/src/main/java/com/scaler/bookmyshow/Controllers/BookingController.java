package com.scaler.bookmyshow.Controllers;

import com.scaler.bookmyshow.DTOS.CreateBookingRequest;
import com.scaler.bookmyshow.Models.Booking;
import com.scaler.bookmyshow.Services.BookingService;
import lombok.AllArgsConstructor;
import org.springframework.transaction.support.ResourceTransactionManager;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class BookingController {
    private final ResourceTransactionManager resourceTransactionManager;
    private BookingService bookingService;

    //create booking
    @PostMapping
    public Booking createBooking(@RequestBody CreateBookingRequest request){
        return bookingService.createBooking(request);
    }

}
