package com.labus.transportation.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
public class WaysDTO extends ArrayList<TransportDTO> {
    @Override
    public boolean add(TransportDTO transportDTO) {
        return super.add(transportDTO);
    }
}
