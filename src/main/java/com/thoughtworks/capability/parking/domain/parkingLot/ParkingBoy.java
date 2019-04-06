package com.thoughtworks.capability.parking.domain.parkingLot;

import com.thoughtworks.capability.parking.domain.shared.DomainEntity;

import java.util.Collections;
import java.util.List;

public class ParkingBoy implements Parkable, DomainEntity<ParkingBoy> {

    private final ParkingBoyId parkingBoyId;

    private final List<Parkable> parkables;

    public ParkingBoy(ParkingBoyId parkingBoyId, List<Parkable> parkables) {
        this.parkingBoyId = parkingBoyId;
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

    public ParkingBoyId getParkingBoyId() {
        return parkingBoyId;
    }

    public List<Parkable> getParkables() {
        return Collections.unmodifiableList(parkables);
    }

    @Override
    public boolean sameIdentityAs(ParkingBoy other) {
        return other != null && parkingBoyId.equals(other.parkingBoyId);
    }

    @Override
    public String toString() {
        return "ParkingBoy{\n" +
                "\tparkingBoyId=" + parkingBoyId +
                ",\n\tparkables=" + parkables +
                '}';
    }
}
