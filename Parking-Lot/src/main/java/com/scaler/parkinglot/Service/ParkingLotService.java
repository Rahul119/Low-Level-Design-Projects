package com.scaler.parkinglot.Service;


import com.scaler.parkinglot.Models.ParkingLot;
import com.scaler.parkinglot.Repository.ParkingLotRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class ParkingLotService {

    private ParkingLotRepository parkingLotRepository;
    private ParkingSpotService parkingSpotService;

    public ParkingLot create(ParkingLot parkingLot){
        ParkingLot persistedLot = parkingLotRepository.save(parkingLot);
        parkingSpotService.createParkingSpots(persistedLot);
        return persistedLot;
    }

    public ParkingLot get(Long id){
        return ParkingLot.builder().build();
    }


}
