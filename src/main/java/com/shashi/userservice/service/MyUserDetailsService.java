package com.shashi.userservice.service;

import com.shashi.userservice.Controller.UserResource;
import com.shashi.userservice.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author akshaygupta01
 */
@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    private UserResource userResource;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

       User user= userResource.findUserByName(s);
       return new MyUserDetails(user);
    }
}
