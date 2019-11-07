package com.labus.transportation.service;

import com.labus.transportation.model.Staying;
import com.labus.transportation.repositories.StayingRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StayingService {
    private final StayingRespository stayingRespository;

    @Autowired
    public StayingService(StayingRespository stayingRespository) {
        this.stayingRespository = stayingRespository;
    }

    public Staying save(Staying stock) {
        return stayingRespository.save(stock);
    }


}
