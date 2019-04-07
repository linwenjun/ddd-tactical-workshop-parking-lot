package com.thoughtworks.capability.parking.interfaces.web.facade;

import com.thoughtworks.capability.parking.interfaces.web.facade.dto.ParkingBoyDTO;

public interface ParkingServiceFacade {
    ParkingBoyDTO find(String parkingBoyId);
}
