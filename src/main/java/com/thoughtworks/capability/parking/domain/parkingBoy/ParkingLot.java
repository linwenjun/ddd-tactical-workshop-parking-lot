package com.thoughtworks.capability.parking.domain.parkingBoy;

import com.thoughtworks.capability.parking.domain.shared.ValueObject;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.apache.commons.lang.builder.EqualsBuilder;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "parking_lot")
@NoArgsConstructor
public class ParkingLot implements Parkable, ValueObject<ParkingLot> {

    private int capacity;

    @Id
    private Long parkingLotId;

    private ParkingBoyId parkingBoyId;

    @Transient
    private List<LicensePlate> licensePlates;

    public ParkingLot(int capacity) {
        this.capacity = capacity;
        licensePlates = new ArrayList<>();
    }

    public ParkingLot(int capacity, Long parkingLotId, ParkingBoyId parkingBoyId, List<LicensePlate> licensePlates) {
        this.capacity = capacity;
        this.parkingLotId = parkingLotId;
        this.parkingBoyId = parkingBoyId;
        this.licensePlates = licensePlates;
    }

    public int getCapacity() {
        return capacity;
    }

    @Override
    public void park(LicensePlate licensePlate) {

        if(availableCapacity() < 1) {
            throw new NoEnoughCapacityException();
        }

        licensePlates.add(licensePlate);
    }

    @Override
    public int availableCapacity() {
        return capacity - licensePlates.size();
    }

    @Override
    public LicensePlate pick(LicensePlate lp) {
        LicensePlate licensePlate = licensePlates.stream()
                .filter(license -> license.equals(lp))
                .findFirst()
                .orElseThrow(IllegalTicketException::new);

        licensePlates.remove(licensePlate);
        return licensePlate;
    }

    @Override
    public String toString() {
        return "ParkingLot{" +
                "capacity=" + capacity +
                ", licensePlates=" + licensePlates +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) return true;
        if(obj == null) return false;
        if(getClass() != obj.getClass()) return false;

        ParkingLot other = (ParkingLot) obj;
        return sameValueAs(other);
    }

    @Override
    public boolean sameValueAs(ParkingLot other) {
        return other!=null && new EqualsBuilder()
                .append(parkingLotId, other.parkingLotId)
                .append(parkingBoyId, other.parkingBoyId)
                .append(licensePlates, other.licensePlates)
                .isEquals();
    }
}
