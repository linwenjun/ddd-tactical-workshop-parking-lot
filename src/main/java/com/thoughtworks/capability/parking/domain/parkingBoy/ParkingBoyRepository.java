package com.thoughtworks.capability.parking.domain.parkingBoy;

import java.util.Optional;

public interface ParkingBoyRepository {
    Optional<ParkingBoy> find(ParkingBoyId parkingBoyId);
    void save(ParkingBoy parkingBoy);
}
