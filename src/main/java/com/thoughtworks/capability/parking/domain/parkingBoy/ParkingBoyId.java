package com.thoughtworks.capability.parking.domain.parkingBoy;

import com.thoughtworks.capability.parking.domain.shared.ValueObject;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ParkingBoyId implements ValueObject<ParkingBoyId> {

    @Column(name = "parking_boy_id")
    private String id;

    public ParkingBoyId() {
    }

    public ParkingBoyId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(obj == null) return false;
        if(getClass() != obj.getClass()) return false;

        ParkingBoyId other = (ParkingBoyId) obj;

        return sameValueAs(other);
    }

    @Override
    public boolean sameValueAs(ParkingBoyId other) {
        return other != null && id.equals(other.id);
    }

    @Override
    public String toString() {
        return id;
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
