package com.labus.transportation.db.sql.service;

import com.labus.transportation.db.sql.repositories.RouteRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RouteService {
    @Autowired
    private RouteRespository routeRespository;

   /* public List<Route> getRoute(DayEnum dayEnum, String staying){
        return routeRespository.findRoutesByStayingNameAndDayEnum(staying, dayEnum);
    }*/

}
