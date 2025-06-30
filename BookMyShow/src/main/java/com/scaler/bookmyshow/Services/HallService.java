package com.scaler.bookmyshow.Services;

import com.scaler.bookmyshow.DTOS.CreateHallRequest;
import com.scaler.bookmyshow.DTOS.SeatPosition;
import com.scaler.bookmyshow.Enums.SeatType;
import com.scaler.bookmyshow.Models.Hall;
import com.scaler.bookmyshow.Models.Seat;
import com.scaler.bookmyshow.Repositories.HallRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.toList;

@Service
@AllArgsConstructor
public class HallService {
    private HallRepository hallRepository;
    private SeatService seatService;

    public static List<Seat> toSeat(Hall hall, Map<SeatType, List<SeatPosition>> seatPositions){

        return seatPositions.entrySet().stream().flatMap(entry -> {

            SeatType seatType = entry.getKey();
            List<SeatPosition> positions = entry.getValue();

            return positions
                    .stream()
                    .map(seatPosition->
                            Seat.builder()
                                    .seatType(seatType)
                                    .rowNo(seatPosition.getRowNo())
                                    .columnNo(seatPosition.getColumnNo())
                                    .hall(hall)
                                    .build());
    }).toList();
        public Hall createHall(CreateHallRequest request){
        Hall hallRequest = Hall.builder()
                .name(request.getName())
                .features(request.getFeatures())
                .build();
        Hall initialHall = hallRepository.save(hallRequest);

        List<Seat> seats= toSeats(initialHall, request.getSeatRanges());
        List<Seat> savedSeats = seatService.saveAll(seats);

        return hallRepository.save(initialHall.toBuilder().seats(savedSeats).build());
    }

    public Hall getHall(Long id){
        return hallRepository.findById(id).orElse(null);
    }
}
