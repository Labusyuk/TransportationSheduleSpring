package com.labus.transportation.service;

import com.labus.transportation.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class AuthProvider implements AuthenticationProvider {
    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = (String) authentication.getCredentials();
        System.out.println("auntenfication");

        User user = (User) userService.loadUserByUsername(username);

        if (user != null) {
            if (!passwordEncoder.matches(password, user.getPassword())) {
                System.out.println("Wrong password");
                throw new BadCredentialsException("Wrong password");
            }

            Collection<? extends GrantedAuthority> authorities = user.getAuthorities();

            return new UsernamePasswordAuthenticationToken(user, password, authorities);
        } else {
            System.out.println("Username not found");
            throw new BadCredentialsException("Username not found");
        }
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}