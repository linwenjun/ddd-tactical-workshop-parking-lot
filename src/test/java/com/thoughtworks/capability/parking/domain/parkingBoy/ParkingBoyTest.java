package com.thoughtworks.capability.parking.domain.parkingBoy;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class ParkingBoyTest {

    ParkingLot firstParkingBoy, secondParkingBoy;
    List<ParkingLot> parkableList;
    ParkingBoy parkingBoy;

    @Before
    public void setUp() throws Exception {
        firstParkingBoy = mock(ParkingLot.class);
        secondParkingBoy = mock(ParkingLot.class);

        parkableList = Arrays.asList(firstParkingBoy, secondParkingBoy);
        parkingBoy = new ParkingBoy(new ParkingBoyId("pb01"), parkableList);
    }

    @Test
    public void first_parkable_should_be_called_when_park_a_car () {
        when(firstParkingBoy.availableCapacity()).thenReturn(1);


        parkingBoy.park(new LicensePlate("川A88888"));
        verify(firstParkingBoy, times(1)).park(any());
        verify(secondParkingBoy, never()).park(any());
    }

    @Test(expected = NoEnoughCapacityException.class)
    public void first_parkable_should_not_be_called_when_no_available_capacity () {
        when(firstParkingBoy.availableCapacity()).thenReturn(0);
        when(secondParkingBoy.availableCapacity()).thenReturn(0);
        parkingBoy.park(new LicensePlate("川A88888"));
    }
}