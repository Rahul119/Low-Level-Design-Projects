package com.scaler.parkinglot.Generators;

import java.util.concurrent.atomic.AtomicLong;

public class ParkingFloorId {
    private static AtomicLong idCounter = new AtomicLong();

    public static long nextId() {
        return idCounter.getAndIncrement();
    }
}
