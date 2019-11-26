package com.labus.transportation.controller;

import com.labus.transportation.service.TransportService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
@Autowired
    TransportService transportService;
    Logger log = Logger.getLogger(TestController.class);

    @RequestMapping("/test")
    public String test(){
        log.info("test info log4j message");
        String message = "message";
        log.warn("test warn log4j message");
        log.fatal("fatal crash test message");
        return transportService.getTransports().get(0).toString();
    }
}
