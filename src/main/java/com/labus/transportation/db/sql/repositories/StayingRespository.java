package com.labus.transportation.db.sql.repositories;

import com.labus.transportation.db.sql.model.Staying;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StayingRespository extends JpaRepository<Staying, Integer> {
    List<Staying> findBy();
}
