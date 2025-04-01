package com.scaler.parkinglot.Service;

import com.scaler.parkinglot.Models.Vehicle;
import com.scaler.parkinglot.Models.VehicleType;
import org.springframework.stereotype.Service;

@Service
public class VehicleService {

    public Vehicle findOrCreate(String vehicleNumber, VehicleType vehicleType) {

        return Vehicle
                .builder()
                .licenseNumber(vehicleNumber)
                .type(vehicleType)
                .build();
    }
}
