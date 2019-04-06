package com.thoughtworks.capability.parking.domain.parkingBoy;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class ParkingBoyTest {

    Parkable firstParkable, secondParkable;
    List<Parkable> parkableList;
    ParkingBoy parkingBoy;

    @Before
    public void setUp() throws Exception {
        firstParkable = mock(Parkable.class);
        secondParkable = mock(Parkable.class);

        parkableList = Arrays.asList(firstParkable, secondParkable);
        parkingBoy = new ParkingBoy(new ParkingBoyId("pb01"), parkableList);
    }

    @Test
    public void first_parkable_should_be_called_when_park_a_car () {
        when(firstParkable.availableCapacity()).thenReturn(1);


        parkingBoy.park(new LicensePlate("川A88888"));
        verify(firstParkable, times(1)).park(any());
        verify(secondParkable, never()).park(any());
    }

    @Test(expected = NoEnoughCapacityException.class)
    public void first_parkable_should_not_be_called_when_no_available_capacity () {
        when(firstParkable.availableCapacity()).thenReturn(0);
        when(secondParkable.availableCapacity()).thenReturn(0);
        parkingBoy.park(new LicensePlate("川A88888"));
    }
}