package com.thoughtworks.capability.parking.infrastructure.memoryRepository;

import com.thoughtworks.capability.parking.domain.parkingBoy.*;

import java.util.*;

public class ParkingBoyRepositoryMemoryImpl implements ParkingBoyRepository {

    private List<ParkingBoy> parkingBoys;

    {
        parkingBoys = new ArrayList<>();

        List<ParkingLot> parkingLots = Arrays.asList(
                new ParkingLot(1),
                new ParkingLot(5)
        );

        ParkingBoy parkingBoy = new ParkingBoy(new ParkingBoyId("parking-boy-001"), "张三", parkingLots);

        parkingBoys.add(parkingBoy);
    }

    @Override
    public ParkingBoy find(ParkingBoyId parkingBoyId) {
        return parkingBoys.stream()
                .filter(parkingBoy -> parkingBoy.getParkingBoyId().equals(parkingBoyId))
                .findFirst()
                .get();
    }

    @Override
    public void save(ParkingBoy parkingBoy) {
        parkingBoys.remove(parkingBoy);
        parkingBoys.add(parkingBoy);
    }
}
