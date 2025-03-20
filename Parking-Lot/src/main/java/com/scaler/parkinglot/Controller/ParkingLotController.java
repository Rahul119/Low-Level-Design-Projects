package com.scaler.parkinglot.Controller;

import com.scaler.parkinglot.DTO.CreateParkingLotRequest;
import com.scaler.parkinglot.Models.ParkingLot;

import static org.apache.catalina.startup.ExpandWar.validate;

public class ParkingLotController {

    private ParkingLotService parkingLotService = new ParkingLotService();
    //Create parking Log
    //Post
    //1. One of the work of Controller is Request Validation
    //2. Data transformation

    public ParkingLot createParkingLot(CreateParkingLotRequest request){
        validate(request);
        ParkingLot parkingLot = transform(request);
        return parkingLotService.create(parkingLot);
    }

    private void validate(CreateParkingLotRequest request) {
        if (request.getNumberOfFloors() < 0){
            throw new RuntimeException("Invalid number of floors");
        }
    }

    private ParkingLot transform(CreateParkingLotRequest request){
        return new ParkingLot();
    }
}
