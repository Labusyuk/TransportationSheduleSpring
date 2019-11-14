package com.labus.transportation.repositories;

import com.labus.transportation.model.Showcase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShowcaseRespository extends JpaRepository<Showcase, Integer> {
}
