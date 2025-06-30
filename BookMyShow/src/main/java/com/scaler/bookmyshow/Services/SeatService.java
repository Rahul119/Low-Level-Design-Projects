package com.scaler.bookmyshow.Services;

import com.scaler.bookmyshow.Models.Seat;
import com.scaler.bookmyshow.Repositories.SeatRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SeatService {
    private SeatRepository seatRepository;

    public List<Seat> saveAll(List<Seat> seats) {
        return seatRepository.saveAll(seats);
    }

    public List<Seat> getAll(Long hallId){
        return seatRepository.findAllByHall_Id(hallId);
    }
}
