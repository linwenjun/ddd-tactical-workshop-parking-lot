package com.thoughtworks.capability.parking.domain.parkingLot;

import java.util.List;

public class ParkingBoy implements Parkable{

    List<Parkable> parkables;

    public ParkingBoy(List<Parkable> parkables) {
        this.parkables = parkables;
    }

    @Override
    public void park(LicensePlate licensePlate) {
        Parkable first = parkables.stream()
                .filter(parkable -> parkable.availableCapacity() > 0)
                .findFirst()
                .orElseThrow(NoEnoughCapacityException::new);

        first.park(licensePlate);
    }

    @Override
    public int availableCapacity() {
        return 0;
    }

    @Override
    public LicensePlate pick(LicensePlate ticket) {
        return null;
    }
}
