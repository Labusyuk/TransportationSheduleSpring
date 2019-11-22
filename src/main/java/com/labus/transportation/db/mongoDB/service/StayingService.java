package com.labus.transportation.db.mongoDB.service;

import com.labus.transportation.db.mongoDB.model.Staying;
import com.labus.transportation.db.mongoDB.repositories.StayingRespository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StayingService {
    private StayingRespository stayingRespository;
    public Staying save(Staying stock) {
        return stayingRespository.save(stock);
    }

    public List<Staying> getStaying(){
        return stayingRespository.findAll();
    }
    public List<Staying> getDistinctStaying(){
        return stayingRespository.findDistinctByName();
    }
}
