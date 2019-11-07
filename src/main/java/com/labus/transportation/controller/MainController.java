package com.labus.transportation.controller;

import com.labus.transportation.model.Route;
import com.labus.transportation.model.enums.DayEnum;
import com.labus.transportation.service.RouteService;
import com.labus.transportation.service.StayingService;
import com.labus.transportation.service.TransportService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/")
public class MainController {
    private final TransportService transportService;
    private final StayingService stayingService;
    private final RouteService routeService;

    public MainController(TransportService transportService, StayingService stayingService, RouteService routeService) {
        this.transportService = transportService;
        this.stayingService = stayingService;
        this.routeService = routeService;
    }

    @GetMapping()
    public String greeting(@RequestParam(name = "name", required = false, defaultValue = "World") String name, Model model) {
        model.addAttribute("name", name);
        /*try {
            model.addAttribute("stayings", TransportPool.getInstance().getStaying());

        } catch (IOException e) {
            e.printStackTrace();
        }*/

        for(Route route: routeService.getRoute(DayEnum.WORKING, "Педучилище")){
            System.out.println(route.getTransport()+" "+route.getLocalTime()+" "+route.getPosition());
        }
        return "index";
    }


}