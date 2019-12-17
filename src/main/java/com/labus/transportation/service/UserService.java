package com.labus.transportation.service;

import com.labus.transportation.model.User;
import com.labus.transportation.model.enums.RoleEnum;
import com.labus.transportation.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    UserRepository userRepository;

    public boolean checkUsefulUsername(String username){
        return userRepository.findByUsername(username)!=null;

    }

    public boolean checkUsefulEmail(String email){
        return userRepository.findByEmail(email)!=null;
    }

    public Integer save(User user){
        return userRepository.save(user).getId();
    }

    public boolean add(User user){
        if(!checkUsefulUsername(user.getUsername())) {
            user.setEnabled(true);
            user.setCredentialsNonExpired(true);
            user.setAccountNonLocked(true);
            user.setAccountNonExpired(true);
            save(user);
            return true;
        }else
            return false;
    }

    public Long getUserCount(){
        return userRepository.count();
    }

    public User findByEmail(String userName){
        return userRepository.findByEmail(userName);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
            UserDetails user = userRepository.findByUsername(username);
            if(user != null){
                return user;
            }
            return null;
    }
    public User findByGoogleUsername(String userName){
        return userRepository.findByGoogleUsername(userName);
    }
}
