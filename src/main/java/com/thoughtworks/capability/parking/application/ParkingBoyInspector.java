package com.thoughtworks.capability.parking.application;

import com.thoughtworks.capability.parking.domain.parkingBoy.ParkingBoy;
import com.thoughtworks.capability.parking.domain.parkingBoy.ParkingBoyId;

public interface ParkingBoyInspector {

    ParkingBoy find(ParkingBoyId parkingBoyId);
}
