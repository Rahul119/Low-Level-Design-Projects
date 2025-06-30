package com.scaler.bookmyshow.Services;

import com.scaler.bookmyshow.Models.ShowSeat;
import com.scaler.bookmyshow.Repositories.ShowSeatRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ShowSeatService {

    private ShowSeatRepository showSeatRepository;

    public List<ShowSeat> saveAll(List<ShowSeat> showSeats){
        return showSeatRepository.saveAll(showSeats);
    }

    public List<ShowSeat> getShowSeats(List<Long> showSeatIds){
        return showSeatRepository.findAllById(showSeatIds);
    }
}
