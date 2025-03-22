package com.scaler.parkinglot.Controller;

import com.scaler.parkinglot.Models.ParkingLot;


public class ParkingLotService {


    public ParkingLot create(ParkingLot parkingLot) {

        return parkingLot;
    }

    public ParkingLot get(Long id) {
        return ParkingLot.builder().build();
    }
}
