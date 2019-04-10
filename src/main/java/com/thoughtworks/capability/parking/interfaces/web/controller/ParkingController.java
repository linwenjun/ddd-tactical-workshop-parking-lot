package com.thoughtworks.capability.parking.interfaces.web.controller;

import com.thoughtworks.capability.parking.interfaces.web.facade.ParkingServiceFacade;
import com.thoughtworks.capability.parking.interfaces.web.facade.dto.ParkingBoyDTO;
import com.thoughtworks.capability.parking.interfaces.web.facade.impl.ParkingServiceFacadeImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("parking-boy")
public class ParkingController {

    private ParkingServiceFacade parkingServiceFacade;

    @Autowired
    public ParkingController(ParkingServiceFacadeImpl parkingService) {
        this.parkingServiceFacade = parkingService;
    }




    @GetMapping("/{parkingBoyId}")
    ParkingBoyDTO getParkingBoy(@PathVariable String parkingBoyId) {
        return parkingServiceFacade.find(parkingBoyId);
    }
}
