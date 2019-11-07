package com.labus.transportation.service;

import com.labus.transportation.model.Route;
import com.labus.transportation.model.enums.DayEnum;
import com.labus.transportation.repositories.RouteRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RouteService {
    private final RouteRespository routeRespository;
    @Autowired
    public RouteService(RouteRespository routeRespository) {
        this.routeRespository = routeRespository;
    }

    public List<Route> getRoute(DayEnum dayEnum, String staying){
        return routeRespository.findRoutesByStayingNameAndDayEnum(staying, dayEnum);
    }

}
