package com.thoughtworks.capability.parking.domain.parkingLot;

public class NoEnoughCapacityException extends RuntimeException {

    @Override
    public String getMessage() {
        return "No enough capacity of this parking lot";
    }
}
