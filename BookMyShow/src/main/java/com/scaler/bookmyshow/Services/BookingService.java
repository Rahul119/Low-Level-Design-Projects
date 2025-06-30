package com.scaler.bookmyshow.Services;

import com.scaler.bookmyshow.DTOS.CreateBookingRequest;
import com.scaler.bookmyshow.Enums.BookingStatus;
import com.scaler.bookmyshow.Enums.SeatStatus;
import com.scaler.bookmyshow.Exceptions.InvalidCustomerException;
import com.scaler.bookmyshow.Models.Booking;
import com.scaler.bookmyshow.Models.Customer;
import com.scaler.bookmyshow.Models.Show;
import com.scaler.bookmyshow.Models.ShowSeat;
import com.scaler.bookmyshow.Repositories.BookingRepository;
import com.scaler.bookmyshow.Strategies.PricingStrategy;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;

import java.security.InvalidParameterException;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class BookingService {
    private BookingRepository bookingRepository;
    private CustomerService customerService;
    private ShowService showService;
    private ShowSeatService showSeatService;

    private PricingStrategy pricingStrategy;

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public Booking createBooking(CreateBookingRequest request){
        //Step-1 Get the user through Id.
        //Step-1b If user is not present, throw error.

        Customer customer = customerService.getCustomerInternal(request.getCustomerId());
        if (customer == null){
            throw new NoSuchElementException("Invalid Customer Id: " + request.getCustomerId());
        }
        //Step-2 Get the show seats using showSeat IDs
        //Step-2b If show is not present, throe error
        Show show = showService.getShow(request.getShowId());

        //step-3 Get the show seat using show Seat IDs
        //step-4 Check if all the seats are available
        List<ShowSeat> showSeats= showSeatService.getShowSeats(request.getShowSeatsId());
        for (ShowSeat seat : showSeats) {
            if(seat.getStatus()!= SeatStatus.AVAILABLE){
                throw new InvalidParameterException("Seat is not available");
            }
        }

        //step-5 Mark all the seats blocked
        for (ShowSeat seat: showSeats){
            seat.setStatus(SeatStatus.LOCKED);
        }
        List<ShowSeat> savedSeats = showSeatService.saveAll(showSeats);

        //Step-6 Create and save the booking
        Booking booking = Booking.builder()
                .customer(customer)
                .show(show)
                .seats(savedSeats)
                .status(BookingStatus.PENDING)
                .bookedAt(new Date())
                .build();

        Double amount = pricingStrategy.calculatePrice(booking);
        Booking withPrice = booking.toBuilder().amount(amount).build();
        return bookingRepository.save(withPrice);
    }
}
