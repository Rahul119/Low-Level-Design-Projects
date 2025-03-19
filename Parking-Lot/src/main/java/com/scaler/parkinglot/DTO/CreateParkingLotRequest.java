package com.scaler.parkinglot.DTO;

import com.scaler.parkinglot.Models.ParkingSpot;

public class CreateParkingLotRequest {

    private String name;
    private String address;

    private Integer numberOfFloors;
    private Integer numberOfSpotsPerFloor;

    private Integer numberOfEntryGates;
    private Integer numberOfExitGates;
}
