package com.labus.transportation.service;

import com.labus.transportation.model.Staying;
import com.labus.transportation.repositories.StayingRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StayingService {
    @Autowired
    private StayingRespository stayingRespository;
    public Staying save(Staying stock) {
        return stayingRespository.save(stock);
    }
    public List<Staying> getAll(){
        return stayingRespository.findBy();
    }


}
