package com.labus.transportation.controller;

import com.labus.transportation.model.User;
import com.labus.transportation.model.enums.RoleEnum;
import com.labus.transportation.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;
import java.util.Set;

@Controller
public class AuthController {
    Logger log = Logger.getLogger(AuthController.class);
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String getLoginPage(){
        return "login";
    }
    @RequestMapping(value = "/login?error", method = RequestMethod.POST)
    public String auth(Map<String, Object> model){
       model.put("userNotExist", "Користувач з таким логіном і паролем не знайдений");
        return "/login";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(User user, Map<String, Object> model){
        boolean correctData = true;
        if(userService.checkUsefulUsername(user.getUsername())) {
            model.put("usernameAlreadyInUse", "Імя користувача вже використовується");
            correctData = false;
        }
        if(!user.getPassword().equals(user.getConfirmPassword())) {
            model.put("confirmPassword", "Паролі не збігаються");
            correctData = false;
        }
        if(userService.checkUsefulEmail(user.getEmail())) {
            model.put("emailAlreadyInUse", "E-mail користувача вже використовується");
            correctData = false;
        }
        System.out.println(correctData+" "+user.getUsername()+" "+passwordEncoder.encode((user.getPassword())));
        user.setAuthorities(Set.of(RoleEnum.USER));
        user.setPassword(passwordEncoder.encode((user.getPassword())));
        if(userService.add(user))
            return "redirect:/";
        return "login";
    }


}
