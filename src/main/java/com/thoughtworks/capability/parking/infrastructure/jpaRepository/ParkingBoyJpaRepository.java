package com.thoughtworks.capability.parking.infrastructure.jpaRepository;

import com.thoughtworks.capability.parking.domain.parkingBoy.ParkingBoy;
import com.thoughtworks.capability.parking.domain.parkingBoy.ParkingBoyId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParkingBoyJpaRepository extends JpaRepository<ParkingBoy, ParkingBoyId> {
}
