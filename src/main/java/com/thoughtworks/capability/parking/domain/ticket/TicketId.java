package com.thoughtworks.capability.parking.domain.ticket;

import com.thoughtworks.capability.parking.domain.shared.ValueObject;

public class TicketId implements ValueObject<TicketId> {

    private final String uuid;

    public TicketId(String uuid) {
        this.uuid = uuid;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) return true;
        if(obj == null) return false;
        if(getClass() != obj.getClass()) return false;

        TicketId other = (TicketId) obj;

        return sameValueAs(other);
    }

    @Override
    public boolean sameValueAs(TicketId other) {
        return other !=null && uuid.equals(other.uuid);
    }
}
