package com.thoughtworks.capability.parking.domain.ticket;

import com.thoughtworks.capability.parking.domain.parkingLot.LicensePlate;

public class Ticket {
    private LicensePlate licensePlate;

    public Ticket(LicensePlate licensePlate) {
        this.licensePlate = licensePlate;
    }

    public LicensePlate getLicensePlate() {
        return this.licensePlate;
    }
}
