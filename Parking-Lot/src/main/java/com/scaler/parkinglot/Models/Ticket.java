package com.scaler.parkinglot.Models;

import lombok.Getter;
import lombok.experimental.SuperBuilder;
import java.util.Date;

@SuperBuilder
@Getter

public class Ticket extends BaseModel{

    private Long vehicleId;

    private Date entryTime;
    private Long spotId;
    private Long entryGateId;
}
