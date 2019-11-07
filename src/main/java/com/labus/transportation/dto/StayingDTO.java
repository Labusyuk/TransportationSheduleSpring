package com.labus.transportation.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;
import java.util.List;

@Getter
@Setter
public class StayingDTO {
    private String name;
    private int position;
    private int timeAfterStart;
    private List<LocalTime> workingDay, weekend;
}
