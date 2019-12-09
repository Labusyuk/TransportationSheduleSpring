package com.labus.transportation.model.enums;

import org.springframework.security.core.GrantedAuthority;

public enum  RoleEnum implements GrantedAuthority {
    GUEST("Гість"), USER("USER"), ADMIN("Адмін");
    String role;
    RoleEnum(String role){
        this.role = role;
    }
    public String getRole(){
        return role;
    }

    @Override
    public String getAuthority() {
        return name();
    }
}
