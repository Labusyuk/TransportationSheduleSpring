package com.labus.transportation.repositories;

import com.labus.transportation.model.Staying;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StayingRespository extends JpaRepository<Staying, Integer> {
    @Query(value = "SELECT '*' FROM Staying GROUP BY name")
    List<Staying> getDistinct();


}
