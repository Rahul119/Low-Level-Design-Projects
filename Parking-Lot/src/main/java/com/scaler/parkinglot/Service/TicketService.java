package com.scaler.parkinglot.Service;

import com.scaler.parkinglot.DTO.CreateTicketRequest;
import com.scaler.parkinglot.Models.ParkingSpot;
import com.scaler.parkinglot.Models.SpotStatus;
import com.scaler.parkinglot.Models.Ticket;
import com.scaler.parkinglot.Repository.TicketRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;

@AllArgsConstructor
@Service
public class TicketService {

    private VehicleService vehicleService;
    private ParkingLotService parkingSpotService;

    private TicketRepository ticketRepository;

    public Ticket createTicket(CreateTicketRequest request) {

        // Check if parking lot is full
        ParkingSpot parkingSpot = parkingSpotService.allocateSlot(request.getParkingLotId(), request.getVehicleType());
        if (parkingSpot == null) {
            throw new RuntimeException("Slot not available!");
        }

        //update slot status
        parkingSpot.setSpotStatus(SpotStatus.OCCUPIED);

        //Persist slot
        parkingSpotService.update(parkingSpot);

        //create and persist ticket
        Ticket ticket = Ticket
                .builder()
                .entryTime(new Date())
                .spotId(parkingSpot.getId())
                .entryGateId(request.getEntryGateId())
                .vehicle(vehicleService.findOrCreate(request.getVehicleNumber(), request.getVehicleType()))
                .build();

        return ticketRepository.save(ticket);

    }

}
