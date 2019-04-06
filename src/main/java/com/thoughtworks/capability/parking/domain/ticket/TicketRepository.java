package com.thoughtworks.capability.parking.domain.ticket;

public interface TicketRepository {

    void save(Ticket ticket);

    String nextTicketId();
}
