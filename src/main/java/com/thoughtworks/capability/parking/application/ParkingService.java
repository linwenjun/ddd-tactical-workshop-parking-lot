package com.thoughtworks.capability.parking.application;

import com.thoughtworks.capability.parking.domain.parkingBoy.LicensePlate;
import com.thoughtworks.capability.parking.domain.parkingBoy.ParkingBoy;
import com.thoughtworks.capability.parking.domain.parkingBoy.ParkingBoyId;


public interface ParkingService {
    void parking(ParkingBoyId parkingBoyId, LicensePlate licensePlate);
    ParkingBoy get(ParkingBoyId parkingBoyId);
}
