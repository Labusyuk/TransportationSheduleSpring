package com.labus.transportation.controller;

import com.labus.transportation.model.Route;
import com.labus.transportation.model.Showcase;
import com.labus.transportation.model.Staying;
import com.labus.transportation.model.Transport;
import com.labus.transportation.model.enums.DayEnum;
import com.labus.transportation.model.enums.DirectionEnum;
import com.labus.transportation.parser.TransportPool;
import com.labus.transportation.parser.entity.TimeOfDay;
import com.labus.transportation.service.TransportService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.time.LocalTime;
import java.util.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("update")
public class DataUpdateController {
    private final TransportService transportService;
    private Map<String,Staying> stayings = new HashMap<String,Staying>();
    @GetMapping
    public void update(){
        try {
            List<com.labus.transportation.parser.entity.Transport> transportList = TransportPool.getInstance().getTransport();
            for(com.labus.transportation.parser.entity.Transport transport: transportList){

                List<Route> routes = new ArrayList<>();
                Transport newTransport = new Transport();
                newTransport.setName(transport.getName());
                newTransport.setNameType(transport.getNameType());
                int i=0;
                for(com.labus.transportation.parser.entity.Staying staying: transport.getForward()){
                    routes.add(createRoute(staying,newTransport,DirectionEnum.FORWARD,i));
                    i++;
                }
                i=0;
                for(com.labus.transportation.parser.entity.Staying staying: transport.getBackward()){
                    routes.add(createRoute(staying,newTransport,DirectionEnum.BACKWARD,i));
                    i++;
                }
                newTransport.setStaying(routes);
                System.out.println(newTransport.getName());
                transportService.save(newTransport);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Showcase createShowcase(DayEnum working,Route route, TimeOfDay timeOfDay, int timeAfterStart) {
        Showcase showcase = new Showcase();
        showcase.setDayEnum(working);
        showcase.setRoute(route);
        LocalTime localTime = LocalTime.of(timeOfDay.getHour(),timeOfDay.getMinute(),timeOfDay.getSecond());
        showcase.setLocalTime(localTime);
        showcase.setTimeAfterStart(timeAfterStart);
        return showcase;
    }
    private Route createRoute(com.labus.transportation.parser.entity.Staying staying, Transport newTransport, DirectionEnum directionEnum, int i){
        Staying newStaying = getStaying(staying);
        Route route = new Route();
        route.setStaying(newStaying);
        route.setTransport(newTransport);
        route.setPosition(i);
        route.setDirectionEnum(directionEnum);
        List<Showcase> showcases = new ArrayList<>();
        for(TimeOfDay timeOfDay: staying.getShowCaseWorkingDays()){
            Showcase showcase = createShowcase(DayEnum.WORKING,route, timeOfDay,staying.getTimeAfterStart());
            showcases.add(showcase);
        }
        for(TimeOfDay timeOfDay: staying.getShowCaseWeekend()){
            Showcase showcase = createShowcase(DayEnum.WEEKEND, route, timeOfDay,staying.getTimeAfterStart());
            showcases.add(showcase);
        }
        route.setShowcase(showcases);
        return route;
    }

    private Staying getStaying(com.labus.transportation.parser.entity.Staying staying){
        Staying newStaying;
        if(stayings.get(staying.getName())==null){
            newStaying = new Staying();
            newStaying.setName(staying.getName());
            stayings.put(staying.getName(), newStaying);
        }else newStaying = stayings.get(staying.getName());
        return newStaying;
    }
}
