package com.labus.transportation.db.sql.repositories;

import com.labus.transportation.db.sql.model.Transport;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransportRespository extends JpaRepository<Transport, Integer> {
    List<Transport> findAll();
}
