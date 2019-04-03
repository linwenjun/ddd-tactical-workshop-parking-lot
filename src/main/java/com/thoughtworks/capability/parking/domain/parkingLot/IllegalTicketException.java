package com.thoughtworks.capability.parking.domain.parkingLot;

public class IllegalTicketException extends RuntimeException {

    @Override
    public String getMessage() {
        return "Illegal Ticket";
    }
}
