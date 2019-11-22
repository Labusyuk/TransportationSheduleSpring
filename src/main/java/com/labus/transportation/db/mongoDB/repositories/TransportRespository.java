package com.labus.transportation.db.mongoDB.repositories;

import com.labus.transportation.db.mongoDB.model.Transport;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransportRespository extends MongoRepository<Transport, Integer> {
    List<Transport> findAll();
}
