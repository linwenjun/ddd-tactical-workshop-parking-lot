package com.thoughtworks.capability.parking.domain.parkingLot;

import java.util.Optional;

public interface ParkingBoyRepository {
    Optional<ParkingBoy> find(ParkingBoyId parkingBoyId);
    void save(ParkingBoy parkingBoy);
}
