package com.labus.transportation.db.sql.repositories;

import com.labus.transportation.db.sql.model.Route;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RouteRespository extends JpaRepository<Route, Integer> {
}
