package com.scaler.parkinglot.Models;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.security.cert.CertPathBuilder;
import java.util.ArrayList;
import java.util.List;
@SuperBuilder
@Getter
public class ParkingLot extends BaseModel {

    private String name;
    private String address;

    private List<ParkingFloor> floors = new ArrayList<>();

    private List<Gate> entryGates = new ArrayList<>();
    private List<Gate> exitGates = new ArrayList<>();

    private DisplayBoard displayBoard;

}
