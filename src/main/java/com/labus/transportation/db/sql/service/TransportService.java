package com.labus.transportation.db.sql.service;

import com.labus.transportation.db.sql.model.Transport;
import com.labus.transportation.db.sql.repositories.TransportRespository;
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
        System.out.printf("TransportService.getTransports");
        return transportRespository.findAll();
    }

}
