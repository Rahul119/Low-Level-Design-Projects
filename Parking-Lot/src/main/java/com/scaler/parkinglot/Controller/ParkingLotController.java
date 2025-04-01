package com.scaler.parkinglot.Controller;

import com.scaler.parkinglot.DTO.CreateParkingLotRequest;
import com.scaler.parkinglot.Models.ParkingLot;
import com.scaler.parkinglot.Service.ParkingLotService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import static org.apache.catalina.startup.ExpandWar.validate;

//Step 1- Add RestController Annotation
@AllArgsConstructor
@RestController// to know spring this is the controller
@RequestMapping("/api/v1/parking-lot")//Step- 2 Map all the request for this url to this controller
public class ParkingLotController {

    private ParkingLotService parkingLotService;
    //Create parking Log
    //Post
    //1. One of the work of Controller is Request Validation
    //2. Data transformation

    //POST /api/v1/parking-lot
    @PostMapping
    public ParkingLot createParkingLot(@RequestBody CreateParkingLotRequest request){
        validate(request);
        ParkingLot parkingLot = transform(request);
        return parkingLotService.create(parkingLot);
    }

    //GET /api/v1/parking-lot/{id}
    @GetMapping("{id}")//Step -3 Add method level mapping
    public ParkingLot getParkingLot(@PathVariable("id") Long id){//Step -4 Add path variable
        return ParkingLot.builder().id(id).build();
    }

    private void validate(CreateParkingLotRequest request) {
        if (request.getNumberOfFloors() == null){
            throw new RuntimeException("Invalid number of floors");
        }
    }

    private ParkingLot transform(CreateParkingLotRequest request){
        return request.toParkingLot();
    }
}
