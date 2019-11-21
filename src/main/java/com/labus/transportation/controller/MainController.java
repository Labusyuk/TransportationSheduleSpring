package com.labus.transportation.controller;

import com.labus.transportation.model.Route;
import com.labus.transportation.model.Staying;
import com.labus.transportation.model.enums.DayEnum;
import com.labus.transportation.service.RouteService;
import com.labus.transportation.service.StayingService;
import com.labus.transportation.service.TransportService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.*;


@Controller
public class

MainController {
    @Autowired
    private StayingService stayingService;
    private final Logger log = LoggerFactory.getLogger(MainController.class);


    @RequestMapping("/")
    public String greeting(HttpServletRequest request, @RequestParam(name = "staying1", required = false, defaultValue = "Ринок Вишенька") String firstStaying, @RequestParam(name = "staying2", required = false, defaultValue = "Залізничний вокзал") String secondStaying, Map<String, Object> model) {
        log.info("Loging bussines logic");
        model.put("staying1",firstStaying );
        model.put("staying2",secondStaying );
        List<Staying> stayingList =  stayingService.getAll();
        stayingList.sort(Comparator.comparing(Staying::getName));
        model.put("stayings",stayingList );
        return "index";
    }
}