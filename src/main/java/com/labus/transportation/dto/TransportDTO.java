package com.labus.transportation.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TransportDTO {
    private String name;
    private String nameType;
    private List<StayingDTO> forwardRoute, backwardRoute;
}
