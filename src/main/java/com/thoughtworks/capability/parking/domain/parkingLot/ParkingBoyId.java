package com.thoughtworks.capability.parking.domain.parkingLot;

import com.thoughtworks.capability.parking.domain.shared.ValueObject;

public class ParkingBoyId implements ValueObject<ParkingBoyId> {

    private final String uuid;

    public ParkingBoyId(String uuid) {
        this.uuid = uuid;
    }

    public String getUuid() {
        return uuid;
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
        return other != null && uuid.equals(other.uuid);
    }

    @Override
    public String toString() {
        return "ParkingBoyId{" +
                "uuid='" + uuid + '\'' +
                '}';
    }
}
