package com.thoughtworks.capability.parking.domain.parkingLot;

import com.thoughtworks.capability.parking.domain.ticket.Ticket;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ParkingLotTest {

    ParkingLot firstParkingLot;
    ParkingLot secondParkingLot;

    @Before
    public void setUp() throws Exception {
        firstParkingLot = new ParkingLot(1);
        secondParkingLot = new ParkingLot(2);
    }

    @Test
    public void should_park_a_car() {

        assertThat(firstParkingLot.availableCapacity(), is(1));

        LicensePlate licensePlate = new LicensePlate("川A88888");
        firstParkingLot.park(licensePlate);
        assertThat(firstParkingLot.availableCapacity(), is(0));
    }

    @Test
    public void should_park_2_cars() {
        assertThat(secondParkingLot.availableCapacity(), is(2));

        secondParkingLot.park(new LicensePlate("川A88888"));
        assertThat(secondParkingLot.availableCapacity(), is(1));

        secondParkingLot.park(new LicensePlate("川A88889"));
        assertThat(secondParkingLot.availableCapacity(), is(0));
    }

    @Test(expected = NoEnoughCapacityException.class)
    public void should_not_park_2_cars_when_parking_lot_has_only_1_capacity() {
        firstParkingLot.park(new LicensePlate("川A88888"));
        firstParkingLot.park(new LicensePlate("川A88889"));
    }

    @Test
    public void should_pick_car_after_stop_it() {
        firstParkingLot.park(new LicensePlate("川A88888"));
        LicensePlate licensePlate = firstParkingLot.pick(new LicensePlate("川A88888"));

        assertEquals(licensePlate, new LicensePlate("川A88888"));

        assertEquals(firstParkingLot.availableCapacity(), 1);
    }

    @Test(expected = IllegalTicketException.class)
    public void should_throw_error_when_pick_car_use_invalid_ticket() {
        firstParkingLot.park(new LicensePlate("川A88888"));
        LicensePlate licensePlate = firstParkingLot.pick(new LicensePlate("not exist"));
    }
}