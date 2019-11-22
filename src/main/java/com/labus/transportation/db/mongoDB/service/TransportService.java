package com.labus.transportation.db.mongoDB.service;

import com.labus.transportation.db.mongoDB.model.Transport;
import com.labus.transportation.db.mongoDB.repositories.TransportRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransportService {
    @Autowired
    private TransportRespository transportRespository;

    public Transport save(Transport stock) {
        return transportRespository.save(stock);
    }

    public List<Transport> getTransports(){
        return transportRespository.findAll();
    }

}
