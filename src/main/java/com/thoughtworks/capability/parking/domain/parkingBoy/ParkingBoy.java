package com.thoughtworks.capability.parking.domain.parkingBoy;

import com.thoughtworks.capability.parking.domain.shared.DomainEntity;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table
@NoArgsConstructor
public class ParkingBoy implements Parkable, DomainEntity<ParkingBoy> {

    @EmbeddedId
    private ParkingBoyId parkingBoyId;

    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @JoinColumn(name = "parking_boy_id")
    private List<ParkingLot> parkingLots;


    public ParkingBoy(ParkingBoyId parkingBoyId, List<ParkingLot> parkingLots) {
        this.parkingBoyId = parkingBoyId;
        this.parkingLots = parkingLots;
    }



    @Override
    public void park(LicensePlate licensePlate) {

        List<Parkable> parkables = parkingLots.stream()
                .map(parkingLot -> (Parkable) parkingLot)
                .collect(Collectors.toList());

        Parkable first = parkingLots.stream()
                .filter(parkable -> parkable.availableCapacity() > 0)
                .findFirst()
                .orElseThrow(NoEnoughCapacityException::new);

        first.park(licensePlate);
    }

    @Override
    public int availableCapacity() {
        return 0;
    }

    @Override
    public LicensePlate pick(LicensePlate ticket) {
        return null;
    }

    public ParkingBoyId getParkingBoyId() {
        return parkingBoyId;
    }

    public List<ParkingLot> getParkingLot() {
        return Collections.unmodifiableList(parkingLots);
    }

    @Override
    public boolean sameIdentityAs(ParkingBoy other) {
        return other != null && parkingBoyId.equals(other.parkingBoyId);
    }

    @Override
    public String toString() {
        return "ParkingBoy{\n" +
                "\tparkingBoyId=" + parkingBoyId +
                ",\n\tparkingLots=" + parkingLots +
                '}';
    }
}
