package com.labus.transportation.repositories;

import com.labus.transportation.model.Staying;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StayingRespository extends JpaRepository<Staying, Integer> {
    List<Staying> findBy();
}
