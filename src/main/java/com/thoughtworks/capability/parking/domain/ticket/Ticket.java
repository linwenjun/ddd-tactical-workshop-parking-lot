package com.thoughtworks.capability.parking.domain.ticket;

import com.thoughtworks.capability.parking.domain.parkingLot.LicensePlate;
import com.thoughtworks.capability.parking.domain.shared.DomainEntity;

public class Ticket implements DomainEntity<Ticket> {

    private final TicketId ticketId;

    private LicensePlate licensePlate;

    public Ticket(TicketId ticketId, LicensePlate licensePlate) {
        this.ticketId = ticketId;
        this.licensePlate = licensePlate;
    }

    public LicensePlate getLicensePlate() {
        return this.licensePlate;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;

        Ticket other = (Ticket) obj;

        return sameIdentityAs(other);
    }

    @Override
    public boolean sameIdentityAs(Ticket other) {
        return other != null && ticketId.equals(other.ticketId);
    }
}
