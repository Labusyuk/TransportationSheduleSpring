package com.labus.transportation.controller;

import com.labus.transportation.model.Route;
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
    @GetMapping
    public void update(){
        try {
            Map<String,Staying> stayings = new HashMap<String,Staying>();
            List<com.labus.transportation.parser.entity.Transport> transportList = TransportPool.getInstance().getTransport();
            for(com.labus.transportation.parser.entity.Transport transport: transportList){
                List<Route> routes = new ArrayList<>();
                Transport newTransport = new Transport();
                newTransport.setName(transport.getName());
                newTransport.setNameType(transport.getNameType());
                int i=0;
                for(com.labus.transportation.parser.entity.Staying staying: transport.getForward()){
                    Staying newStaying;
                    if(stayings.get(staying.getName())==null){
                        newStaying = new Staying();
                        newStaying.setName(staying.getName());
                        stayings.put(staying.getName(), newStaying);
                    }else newStaying = stayings.get(staying.getName());
                    for(TimeOfDay timeOfDay: staying.getShowCaseWorkingDays()){
                        Route newRoute = createRoute(newTransport,DirectionEnum.FORWARD, DayEnum.WORKING, timeOfDay,i,newStaying,staying.getTimeAfterStart());
                        routes.add(newRoute);
                    }
                    for(TimeOfDay timeOfDay: staying.getShowCaseWeekend()){
                        Route newRoute = createRoute(newTransport,DirectionEnum.FORWARD, DayEnum.WEEKEND, timeOfDay,i,newStaying,staying.getTimeAfterStart());
                        routes.add(newRoute);
                    }
                    i++;
                }
                i=0;
                for(com.labus.transportation.parser.entity.Staying staying: transport.getBackward()){
                    Staying newStaying;
                    if(stayings.get(staying.getName())==null){
                        newStaying = new Staying();
                        newStaying.setName(staying.getName());
                        stayings.put(staying.getName(), newStaying);
                    }else newStaying = stayings.get(staying.getName());
                    for(TimeOfDay timeOfDay: staying.getShowCaseWorkingDays()){
                        Route newRoute = createRoute(newTransport,DirectionEnum.BACKWARD, DayEnum.WORKING, timeOfDay,i,newStaying,staying.getTimeAfterStart());
                        routes.add(newRoute);
                    }
                    for(TimeOfDay timeOfDay: staying.getShowCaseWeekend()){
                        Route newRoute = createRoute(newTransport,DirectionEnum.BACKWARD, DayEnum.WEEKEND, timeOfDay,i,newStaying,staying.getTimeAfterStart());
                        routes.add(newRoute);
                    }
                    i++;
                }
                newTransport.setStaying(routes);
                System.out.println(newTransport.getName());
                transportService.save(newTransport);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        /*Transport newTransport = new Transport();
        newTransport.setNameType("Трамвай");
        newTransport.setName("[0 Трамвай]");
        Staying staying = new Staying();
        staying.setName("staying1 1");
        Route route1 = new Route();
        route1.setTransport(newTransport);
        route1.setStaying(staying);
        route1.setLocalTime(LocalTime.now());
        staying.setTransport(Arrays.asList(route1));
        newTransport.setStaying(Arrays.asList(route1));
        transportService.save(newTransport);*/
    }
    private Route createRoute(Transport transport, DirectionEnum direction, DayEnum dayEnum, TimeOfDay timeOfDay, int position, Staying staying, int timeAfterStart){
        Route newRoute = new Route();
        newRoute.setTransport(transport);
        newRoute.setDirectionEnum(direction);
        newRoute.setDayEnum(dayEnum);
        LocalTime localTime = LocalTime.of(timeOfDay.getHour(),timeOfDay.getMinute(),timeOfDay.getSecond());
        newRoute.setLocalTime(localTime);
        newRoute.setPosition(position);
        newRoute.setStaying(staying);
        newRoute.setTimeAfterStart(timeAfterStart);
        return newRoute;
    }
}
