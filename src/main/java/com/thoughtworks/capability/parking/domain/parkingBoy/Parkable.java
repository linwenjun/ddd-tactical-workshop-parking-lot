package com.thoughtworks.capability.parking.domain.parkingBoy;

public interface Parkable {
    void park(LicensePlate licensePlate);
    int availableCapacity();
    LicensePlate pick(LicensePlate ticket);
}
