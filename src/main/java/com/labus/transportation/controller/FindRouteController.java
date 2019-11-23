package com.labus.transportation.controller;

import com.labus.transportation.db.mongoDB.model.Staying;
import com.labus.transportation.db.mongoDB.service.StayingService;
import com.labus.transportation.db.mongoDB.service.TransportService;
import com.labus.transportation.db.mongoDB.utill.ModelMapper;
import com.labus.transportation.dto.StayingDTO;
import com.labus.transportation.dto.TransportDTO;
import com.labus.transportation.logistics.RoadLogistic;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalTime;
import java.util.*;

@RequiredArgsConstructor
@Controller

public class FindRouteController {
    private final TransportService transportService;
    private final StayingService stayingService;
/*    private final RoadLogistic roadLogistic = new RoadLogistic();*/
@RequestMapping("find")
    public String greeting(HttpServletRequest request, @RequestParam(name = "staying1", required = false, defaultValue = "Ринок Вишенька") String firstStaying, @RequestParam(name = "staying2", required = false, defaultValue = "Залізничний вокзал") String secondStaying, @RequestParam(name = "useTime", required = false, defaultValue = "false") String useTime, @RequestParam(name = "time", required = false) String time, @RequestParam(name = "workingDay", required = false, defaultValue = "true") String workingDay, Map<String, Object> model) {
        request.getSession().setAttribute("firstStaying", firstStaying);
        request.getSession().setAttribute("secondStaying", secondStaying);
        model.put("staying1",firstStaying );
        model.put("staying2",secondStaying );
        List<Staying> stayingList =  stayingService.getAllDistinctStaying();
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
