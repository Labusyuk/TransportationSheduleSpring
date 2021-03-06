package com.labus.transportation.controller;

import com.labus.transportation.dto.StayingDTO;
import com.labus.transportation.dto.TransportDTO;
import com.labus.transportation.logistics.RoadLogistic;
import com.labus.transportation.model.Route;
import com.labus.transportation.model.Staying;
import com.labus.transportation.model.Transport;
import com.labus.transportation.service.RouteService;
import com.labus.transportation.service.StayingService;
import com.labus.transportation.service.TransportService;
import com.labus.transportation.utill.ModelMapper;
import lombok.RequiredArgsConstructor;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalTime;
import java.util.*;

@RequiredArgsConstructor
@Controller

public class FindRouteController {
    Logger log = Logger.getLogger(FindRouteController.class);
    private final TransportService transportService;
    private final StayingService stayingService;
/*    private final RoadLogistic roadLogistic = new RoadLogistic();*/
@RequestMapping("find")
    public String greeting(HttpServletRequest request, @RequestParam(name = "staying1", required = false, defaultValue = "Ринок Вишенька") String firstStaying, @RequestParam(name = "staying2", required = false, defaultValue = "Залізничний вокзал") String secondStaying, @RequestParam(name = "useTime", required = false, defaultValue = "false") String useTime, @RequestParam(name = "time", required = false) String time, @RequestParam(name = "workingDay", required = false, defaultValue = "true") String workingDay, Map<String, Object> model) {
        request.getSession().setAttribute("firstStaying", firstStaying);
        request.getSession().setAttribute("secondStaying", secondStaying);
        model.put("staying1",firstStaying );
        model.put("staying2",secondStaying );
        List<Staying> stayingList =  stayingService.getAll();
        stayingList.sort(Comparator.comparing(Staying::getName));
        model.put("stayings",stayingList );
    System.out.printf("--------find---------");

    List<TransportDTO> transports = ModelMapper.convertListTransportToDTO(transportService.getTransports());
        if(!useTime.equals("false") && !time.isEmpty()){
            LocalTime localTime = ModelMapper.convertStringToLocalTime(time);
            boolean workingDayBool = false;
            if(workingDay.equals("true"))
                workingDayBool=true;
            request.getSession().setAttribute("waysList", new RoadLogistic(transports).buildWays(new StayingDTO(firstStaying), new StayingDTO(secondStaying),localTime, !workingDayBool));
        }else
            request.getSession().setAttribute("waysList", new RoadLogistic(transports).buildWays(new StayingDTO(firstStaying), new StayingDTO(secondStaying)));
        return "index";
    }
}
