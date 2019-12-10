package com.labus.transportation.controller;

import com.labus.transportation.service.TransportService;
import com.labus.transportation.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
public class InfoController {
    Logger log = Logger.getLogger(InfoController.class);
    @Autowired
    TransportService transportService;
    @Autowired
    UserService userService;
    @RequestMapping("/info")
    public String getPageCounter(Map<String, Object> model){
        model.put("countTram",transportService.getTransportCount("Трамвай") );
        model.put("countTrolley",transportService.getTransportCount("Тролейбус") );
        model.put("countBus",transportService.getTransportCount("Автобус") );
        model.put("countUser",userService.getUserCount() );
        return "info";
    }
}
