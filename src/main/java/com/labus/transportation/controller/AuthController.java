package com.labus.transportation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@Controller
public class AuthController {
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String getLoginPage(){
        System.out.println("post");
        return "login";
    }
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String auth(){
        System.out.println("post");
        return "login";
    }


}
