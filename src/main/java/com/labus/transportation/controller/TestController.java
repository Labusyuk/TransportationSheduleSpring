package com.labus.transportation.controller;

import com.labus.transportation.model.enums.RoleEnum;
import com.labus.transportation.service.TransportService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class TestController {
    Logger log = Logger.getLogger(DataUpdateController.class);
@Autowired
    TransportService transportService;
    @RequestMapping("/test")
    public Principal test(Principal principal) {
        return principal;
    }
}
