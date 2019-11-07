package com.labus.transportation.service;

import com.labus.transportation.dto.TransportDTO;
import com.labus.transportation.model.Route;
import com.labus.transportation.model.Transport;
import com.labus.transportation.repositories.TransportRespository;
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
