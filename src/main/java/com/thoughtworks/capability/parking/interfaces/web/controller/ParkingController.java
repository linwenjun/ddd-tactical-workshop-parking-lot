package com.thoughtworks.capability.parking.interfaces.web.controller;

import com.thoughtworks.capability.parking.interfaces.web.facade.ParkingServiceFacade;
import com.thoughtworks.capability.parking.interfaces.web.facade.dto.ParkingBoyDTO;
import com.thoughtworks.capability.parking.interfaces.web.facade.impl.ParkingServiceFacadeImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("parking-boy")
public class ParkingController {

    private final ParkingServiceFacade parkingServiceFacade;

    @Autowired
    public ParkingController(ParkingServiceFacadeImpl parkingService) {
        this.parkingServiceFacade = parkingService;
    }


    @GetMapping
    ParkingBoyDTO getParkingBoy() {
        return parkingServiceFacade.find("123");
    }
}
