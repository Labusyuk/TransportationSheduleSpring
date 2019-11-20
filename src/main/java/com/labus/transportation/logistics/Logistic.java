package com.labus.transportation.logistics;

import com.labus.transportation.dto.StayingDTO;
import com.labus.transportation.dto.WaysDTO;

import java.time.LocalTime;
import java.util.List;

public interface Logistic {
    public List<WaysDTO> buildWays(StayingDTO a, StayingDTO b);
    public List<WaysDTO> buildWays(StayingDTO a, StayingDTO b, LocalTime localTime, boolean weekend);
}
