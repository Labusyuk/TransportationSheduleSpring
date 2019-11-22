package com.labus.transportation.db.sql.repositories;

import com.labus.transportation.db.sql.model.Showcase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShowcaseRespository extends JpaRepository<Showcase, Integer> {
}
