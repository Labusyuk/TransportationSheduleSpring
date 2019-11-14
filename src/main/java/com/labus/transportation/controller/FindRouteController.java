package com.labus.transportation.controller;

import com.labus.transportation.dto.StayingDTO;
import com.labus.transportation.dto.TransportDTO;
import com.labus.transportation.model.Route;
import com.labus.transportation.model.Staying;
import com.labus.transportation.model.Transport;
import com.labus.transportation.service.RouteService;
import com.labus.transportation.service.StayingService;
import com.labus.transportation.service.TransportService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Controller
@RequestMapping("find")
public class FindRouteController {
    private final TransportService transportService;
    private final RouteService routeService;
    private final StayingService stayingService;
    @GetMapping
    public String greeting(@RequestParam(name = "firstStaying", required = false) String firstStaying, @RequestParam(name = "secondStaying", required = false) String secondStaying, Model model) {
        model.addAttribute("firstStaying", firstStaying);
        if(firstStaying!=null && secondStaying!=null)
        System.out.println(firstStaying+" "+secondStaying);
        Transport transport = transportService.getTransports().get(0);
            TransportDTO transportDTO = new TransportDTO();
            transportDTO.setName(transport.getName());
            transportDTO.setNameType(transport.getNameType());
        return "index";
    }
}
