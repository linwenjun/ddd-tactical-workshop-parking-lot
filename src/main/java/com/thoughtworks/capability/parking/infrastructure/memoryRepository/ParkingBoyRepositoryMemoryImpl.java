package com.thoughtworks.capability.parking.infrastructure.memoryRepository;

import com.thoughtworks.capability.parking.domain.parkingLot.*;

import java.util.*;

public class ParkingBoyRepositoryMemoryImpl implements ParkingBoyRepository {

    private List<ParkingBoy> parkingBoys;

    {
        parkingBoys = new ArrayList<>();

        List<Parkable> parkingLots = Arrays.asList(
                new ParkingLot(3),
                new ParkingLot(6)
        );

        ParkingBoy parkingBoy = new ParkingBoy(new ParkingBoyId("parking-boy-001"), parkingLots);

        parkingBoys.add(parkingBoy);
    }

    @Override
    public Optional<ParkingBoy> find(ParkingBoyId parkingBoyId) {
        return parkingBoys.stream()
                .filter(parkingBoy -> parkingBoy.getParkingBoyId().equals(parkingBoyId))
                .findFirst();
    }

    @Override
    public void save(ParkingBoy parkingBoy) {
        parkingBoys.remove(parkingBoy);
        parkingBoys.add(parkingBoy);
    }
}
