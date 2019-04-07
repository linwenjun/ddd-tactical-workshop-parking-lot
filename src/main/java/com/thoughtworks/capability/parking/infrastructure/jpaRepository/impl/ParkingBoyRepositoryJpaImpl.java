package com.thoughtworks.capability.parking.infrastructure.jpaRepository.impl;

import com.thoughtworks.capability.parking.domain.parkingBoy.ParkingBoy;
import com.thoughtworks.capability.parking.domain.parkingBoy.ParkingBoyId;
import com.thoughtworks.capability.parking.domain.parkingBoy.ParkingBoyRepository;
import com.thoughtworks.capability.parking.infrastructure.jpaRepository.ParkingBoyJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ParkingBoyRepositoryJpaImpl implements ParkingBoyRepository {

    private final ParkingBoyJpaRepository repository;

    @Autowired
    public ParkingBoyRepositoryJpaImpl(ParkingBoyJpaRepository repository) {
        this.repository = repository;
    }

    @Override
    public ParkingBoy find(ParkingBoyId parkingBoyId) {
        ParkingBoy parkingBoy = repository
                .findById(parkingBoyId)
                .orElse(null);
        
        return parkingBoy;
    }

    @Override
    public void save(ParkingBoy parkingBoy) {

    }
}
