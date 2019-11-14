package com.labus.transportation.repositories;

import com.labus.transportation.model.Route;
import com.labus.transportation.model.Staying;
import com.labus.transportation.model.enums.DayEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RouteRespository extends JpaRepository<Route, Integer> {
}
