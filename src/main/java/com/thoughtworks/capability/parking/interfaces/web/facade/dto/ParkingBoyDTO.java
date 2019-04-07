package com.thoughtworks.capability.parking.interfaces.web.facade.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ParkingBoyDTO {
    private String parkingBoyId;
    private List<ParkingLotDTO> parkingLots;
}
