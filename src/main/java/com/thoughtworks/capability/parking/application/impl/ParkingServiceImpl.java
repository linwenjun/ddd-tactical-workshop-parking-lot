package com.thoughtworks.capability.parking.application.impl;

import com.thoughtworks.capability.parking.application.ParkingService;
import com.thoughtworks.capability.parking.domain.parkingBoy.*;
import com.thoughtworks.capability.parking.domain.ticket.Ticket;
import com.thoughtworks.capability.parking.domain.ticket.TicketId;
import com.thoughtworks.capability.parking.domain.ticket.TicketRepository;

public class ParkingServiceImpl implements ParkingService {

    private final ParkingBoyRepository parkingBoyRepository;
    private final TicketRepository ticketRepository;

    public ParkingServiceImpl(ParkingBoyRepository parkingBoyRepository, TicketRepository ticketRepository) {
        this.parkingBoyRepository = parkingBoyRepository;
        this.ticketRepository = ticketRepository;
    }

    @Override
    public void parking(ParkingBoyId parkingBoyId, LicensePlate licensePlate) {
        ParkingBoy parkingBoy = parkingBoyRepository.find(parkingBoyId)
                .orElseThrow(NoParkingBoyException::new);

        parkingBoy.park(licensePlate);
        parkingBoyRepository.save(parkingBoy);

        TicketId ticketId = new TicketId(ticketRepository.nextTicketId());
        Ticket newTicket = new Ticket(ticketId, licensePlate);

        ticketRepository.save(newTicket);
    }
}
