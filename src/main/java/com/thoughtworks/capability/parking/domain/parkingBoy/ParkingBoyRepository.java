package com.thoughtworks.capability.parking.domain.parkingBoy;

import java.util.Optional;

public interface ParkingBoyRepository {
    ParkingBoy find(ParkingBoyId parkingBoyId);
    void save(ParkingBoy parkingBoy);
}
