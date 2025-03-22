package com.scaler.parkinglot.Models;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
public class ParkingSpot extends BaseModel{

    private Long spotId;
    private Long floorId;

    private VehicleType vehicleType;
    private SportStatus sportStatus;

    public static ParkingSpot mediumAvailable(){
        return ParkingSpot.builder()
                .vehicleType(VehicleType.MEDIUM)
                .sportStatus(SportStatus.AVAILABLE)
                .build();
    }
}
