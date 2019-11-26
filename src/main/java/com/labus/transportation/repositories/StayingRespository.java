package com.labus.transportation.repositories;

import com.labus.transportation.model.Staying;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StayingRespository extends MongoRepository<Staying, Integer> {
    List<Staying> findAll();
    List<Staying> findDistinctByName();
}
