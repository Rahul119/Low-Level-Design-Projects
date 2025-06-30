package com.scaler.bookmyshow.Services;

import com.scaler.bookmyshow.DTOS.CreateShowRequest;
import com.scaler.bookmyshow.Models.*;
import com.scaler.bookmyshow.Repositories.ShowRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class ShowService {

    private final ShowSeatRepository showSeatRepository;
    private HallServive hallServive;
    private ShowRepository showRepository;
    private MovieService movieService;
    private SeatService seatService;

    public Show createShow(CreateShowRequest request) {

        Hall hall= hallServive.getHall(request.getHallId());

        Movie movie = movieService.getMovie(request.getMovieId());

        Show show = Show
                .builder()
                .hall(hall)
                .startTime(request.getStartTime())
                .duration(request.getDuration())
                .movie(movie)
                .build();

        Show savedShow = showRepository.save(show);

        // Task 2
        // Get the seats in the hall using HallId
        // Create the showSeats using the savedShow

        List<Seat> seats = seatService.getAll(request.getHallId());

        List <ShowSeat> showSeats = seats.stream()
                .map(seat ->
                        ShowSeat.builder()
                                .seat(seat)
                                .show(savedShow)
                                .build()
                ).toList();
        //save the show seat
        showSeatRepository.saveAll(showSeats);
        //save the show again
        return showSeatRepository.save(savedShow.toBuilder().showsSeats(showSeats).build());
    }

    public Show getShow(Long id) {
        return showSeatRepository.findById(id).orElseThrow(()-> new NoSuchElementException("Invalid show Id: "+ id));
    }
}
