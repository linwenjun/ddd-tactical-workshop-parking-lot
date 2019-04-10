package com.thoughtworks.capability.parking.infrastructure.jpaRepository.impl;

import com.thoughtworks.capability.parking.domain.ticket.Ticket;
import com.thoughtworks.capability.parking.domain.ticket.TicketRepository;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class TicketRepositoryJpaImpl implements TicketRepository {
    @Override
    public void save(Ticket ticket) {

    }

    @Override
    public String nextTicketId() {
        return UUID.randomUUID().toString();
    }
}
