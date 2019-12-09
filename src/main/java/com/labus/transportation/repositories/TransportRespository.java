package com.labus.transportation.repositories;

import com.labus.transportation.model.Transport;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransportRespository extends JpaRepository<Transport, Integer> {
    List<Transport> findAll();
    List<Transport> findByNameType(String nameType);
}
