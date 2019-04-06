package com.thoughtworks.capability.parking.domain.parkingBoy;

public class IllegalTicketException extends RuntimeException {

    @Override
    public String getMessage() {
        return "Illegal Ticket";
    }
}
