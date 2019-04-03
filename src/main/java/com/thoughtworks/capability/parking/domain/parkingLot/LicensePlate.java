package com.thoughtworks.capability.parking.domain.parkingLot;

public class LicensePlate {
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

    public boolean sameValueAs(LicensePlate other) {
        return other != null && number.equals(other.number);
    }
}
