package com.labus.transportation.db.mongoDB.repositories;

import com.labus.transportation.db.mongoDB.model.Staying;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StayingRespository extends MongoRepository<Staying, Integer> {
    List<Staying> findAll();
    List<Staying> findDistinctByName();
}
