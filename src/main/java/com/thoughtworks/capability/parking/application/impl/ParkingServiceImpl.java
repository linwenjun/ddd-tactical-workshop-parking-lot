package com.thoughtworks.capability.parking.application.impl;

import com.thoughtworks.capability.parking.application.ParkingService;
import com.thoughtworks.capability.parking.domain.parkingBoy.*;
import com.thoughtworks.capability.parking.domain.ticket.Ticket;
import com.thoughtworks.capability.parking.domain.ticket.TicketId;
import com.thoughtworks.capability.parking.domain.ticket.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParkingServiceImpl implements ParkingService {

    private final ParkingBoyRepository parkingBoyRepository;
    private final TicketRepository ticketRepository;

    @Autowired
    public ParkingServiceImpl(ParkingBoyRepository parkingBoyRepository, TicketRepository ticketRepository) {
        this.parkingBoyRepository = parkingBoyRepository;
        this.ticketRepository = ticketRepository;
    }

    @Override
    public void parking(ParkingBoyId parkingBoyId, LicensePlate licensePlate) {
        ParkingBoy parkingBoy = parkingBoyRepository.find(parkingBoyId);

        parkingBoy.park(licensePlate);
        parkingBoyRepository.save(parkingBoy);

        TicketId ticketId = new TicketId(ticketRepository.nextTicketId());
        Ticket newTicket = new Ticket(ticketId, licensePlate);

        ticketRepository.save(newTicket);
    }

    @Override
    public ParkingBoy get(ParkingBoyId parkingBoyId) {
        return parkingBoyRepository.find(parkingBoyId);
    }
}
