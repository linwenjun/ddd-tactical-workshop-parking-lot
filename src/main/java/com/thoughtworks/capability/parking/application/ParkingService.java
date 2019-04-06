package com.thoughtworks.capability.parking.application;

import com.thoughtworks.capability.parking.domain.parkingLot.LicensePlate;
import com.thoughtworks.capability.parking.domain.parkingLot.ParkingBoyId;

public interface ParkingService {
    void parking(ParkingBoyId parkingBoyId, LicensePlate licensePlate);
}
