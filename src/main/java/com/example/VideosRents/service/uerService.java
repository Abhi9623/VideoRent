package com.example.VideosRents.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.VideosRents.repositiory.Userrepository;


@Service
public class uerService  implements UserDetailsService{
   
    @Autowired
     private Userrepository userrepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       return userrepository.findByEmail(username);
    }
    
}
