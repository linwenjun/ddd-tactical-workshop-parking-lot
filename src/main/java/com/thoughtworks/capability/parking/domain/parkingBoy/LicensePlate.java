package com.thoughtworks.capability.parking.domain.parkingBoy;

import com.thoughtworks.capability.parking.domain.shared.ValueObject;

public class LicensePlate implements ValueObject<LicensePlate> {
    private String number;

    public LicensePlate(String number) {

        this.number = number;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(obj == null) return false;
        if(getClass() != this.getClass()) return false;

        LicensePlate other = (LicensePlate) obj;
        return sameValueAs(other);
    }

    @Override
    public boolean sameValueAs(LicensePlate other) {
        return other != null && number.equals(other.number);
    }

    @Override
    public String toString() {
        return "LicensePlate{" +
                "number='" + number + '\'' +
                '}';
    }
}
