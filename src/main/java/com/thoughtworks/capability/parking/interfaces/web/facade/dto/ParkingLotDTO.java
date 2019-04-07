package com.thoughtworks.capability.parking.interfaces.web.facade.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ParkingLotDTO implements Serializable {
    private int capacity;
}
