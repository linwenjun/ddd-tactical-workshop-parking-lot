package com.thoughtworks.capability.parking.application.impl;

import com.thoughtworks.capability.parking.application.ParkingBoyInspector;
import com.thoughtworks.capability.parking.domain.parkingBoy.ParkingBoy;
import com.thoughtworks.capability.parking.domain.parkingBoy.ParkingBoyId;
import com.thoughtworks.capability.parking.domain.parkingBoy.ParkingBoyRepository;
import com.thoughtworks.capability.parking.infrastructure.jpaRepository.ParkingBoyJpaRepository;
import com.thoughtworks.capability.parking.infrastructure.jpaRepository.impl.ParkingBoyRepositoryJpaImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParkingBoyInspectorImpl implements ParkingBoyInspector {

    private final ParkingBoyRepositoryJpaImpl parkingBoyRepository;

    @Autowired
    public ParkingBoyInspectorImpl(ParkingBoyRepositoryJpaImpl parkingBoyRepository) {
        this.parkingBoyRepository = parkingBoyRepository;
    }

    @Override
    public ParkingBoy find(ParkingBoyId parkingBoyId) {
        return parkingBoyRepository.find(parkingBoyId);
    }
}
