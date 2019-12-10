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
    public String test(Principal principal){
        if(principal==null)return RoleEnum.GUEST.getRole();
/*        log.info("test info log4j message");
        String message = "message";
        log.warn("test warn log4j message");
        log.fatal("fatal crash test message");*/
        StringBuilder authorities = new StringBuilder();
        for(GrantedAuthority role:((UserDetails)principal).getAuthorities()) {
            authorities.append(((RoleEnum) role).getRole()).append(" ");
            System.out.println(((RoleEnum) role).getRole());
            System.out.println(((RoleEnum) role).name());
            System.out.println(role.getAuthority());
        }
        return new String(authorities) ;
    }
}
