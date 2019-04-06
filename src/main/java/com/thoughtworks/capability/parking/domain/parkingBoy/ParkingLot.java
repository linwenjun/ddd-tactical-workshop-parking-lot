package com.thoughtworks.capability.parking.domain.parkingBoy;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot implements Parkable {
    private final int capacity;
    private final List<LicensePlate> licensePlates;

    public ParkingLot(int capacity) {
        this.capacity = capacity;
        licensePlates = new ArrayList<>();
    }

    @Override
    public void park(LicensePlate licensePlate) {

        if(availableCapacity() < 1) {
            throw new NoEnoughCapacityException();
        }

        licensePlates.add(licensePlate);
    }

    @Override
    public int availableCapacity() {
        return capacity - licensePlates.size();
    }

    @Override
    public LicensePlate pick(LicensePlate lp) {
        LicensePlate licensePlate = licensePlates.stream()
                .filter(license -> license.equals(lp))
                .findFirst()
                .orElseThrow(IllegalTicketException::new);

        licensePlates.remove(licensePlate);
        return licensePlate;
    }

    @Override
    public String toString() {
        return "ParkingLot{" +
                "capacity=" + capacity +
                ", licensePlates=" + licensePlates +
                '}';
    }
}
