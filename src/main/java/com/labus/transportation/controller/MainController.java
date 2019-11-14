package com.labus.transportation.controller;

import com.labus.transportation.model.Route;
import com.labus.transportation.model.enums.DayEnum;
import com.labus.transportation.service.RouteService;
import com.labus.transportation.service.StayingService;
import com.labus.transportation.service.TransportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/")
public class MainController {
    @Autowired
    private StayingService stayingService;
    @GetMapping()
    public ModelAndView greeting(@RequestParam(name = "name", required = false, defaultValue = "World") String name) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("stayings", stayingService.getAll());
        modelAndView.setViewName("index");

        /*try {
            model.addAttribute("stayings", TransportPool.getInstance().getStaying());

        } catch (IOException e) {
            e.printStackTrace();
        }*/

        /*for(Route route: routeService.getRoute(DayEnum.WORKING, "Педучилище")){
            System.out.println(route.getTransport()+" "+route.getStaying()+" "+route.getPosition());
        }*/
        return modelAndView;
    }


}