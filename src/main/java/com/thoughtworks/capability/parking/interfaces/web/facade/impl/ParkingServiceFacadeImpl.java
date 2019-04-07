package com.thoughtworks.capability.parking.interfaces.web.facade.impl;

import com.thoughtworks.capability.parking.application.ParkingService;
import com.thoughtworks.capability.parking.domain.parkingBoy.ParkingBoy;
import com.thoughtworks.capability.parking.domain.parkingBoy.ParkingBoyId;
import com.thoughtworks.capability.parking.infrastructure.jpaRepository.ParkingBoyJpaRepository;
import com.thoughtworks.capability.parking.interfaces.web.facade.ParkingServiceFacade;
import com.thoughtworks.capability.parking.interfaces.web.facade.assembler.ParkingBoyDTOAssembler;
import com.thoughtworks.capability.parking.interfaces.web.facade.dto.ParkingBoyDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParkingServiceFacadeImpl implements ParkingServiceFacade {

    private final ParkingService parkingService;

    @Autowired
    public ParkingServiceFacadeImpl(ParkingService parkingService) {
        this.parkingService = parkingService;
    }

    @Override
    public ParkingBoyDTO find(String parkingBoyId) {
        ParkingBoy boy = parkingService
                .get(new ParkingBoyId(parkingBoyId));

        return ParkingBoyDTOAssembler.toDTO(boy);
    }
}
