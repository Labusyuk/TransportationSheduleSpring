package com.labus.transportation.db.mongoDB.service;

import com.labus.transportation.model.Staying;
import com.labus.transportation.db.mongoDB.repositories.StayingRespository;
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
    public List<Staying> saveAll (List<Staying> stayings){
        int i=0;
        for(Staying staying:stayings){
            staying.setId(i++);
            stayingRespository.save(staying);
        }
        return stayings;
    }

    public List<Staying> getAllStaying(){
        return stayingRespository.findAll();
    }
}
