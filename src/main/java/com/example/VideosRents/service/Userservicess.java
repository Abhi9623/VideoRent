package com.example.VideosRents.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.VideosRents.Entitie.User;
import com.example.VideosRents.Entitie.Video;
import com.example.VideosRents.enums.Availibilty;
import com.example.VideosRents.enums.Role;
import com.example.VideosRents.exchange.Registerbody;
import com.example.VideosRents.exchange.Respbodyall;
import com.example.VideosRents.exchange.loginbody;
import com.example.VideosRents.repositiory.Userrepository;
import com.example.VideosRents.repositiory.VideoRepository;


@Service
public class Userservicess {
     
    @Autowired
     PasswordEncoder passwordEncoder;
      
     @Autowired
     AuthenticationManager authenticationManager;
     
     @Autowired
     private Userrepository userrepository;

     
     @Autowired
     private VideoRepository videoRepository;


    public Respbodyall register(Registerbody registerbody){
        if(registerbody.getRole()==null){
            registerbody.setRole(Role.USER);
        }

        User user=User.builder().name(registerbody.getName())
        .email(registerbody.getEmail()).password(passwordEncoder.encode(registerbody.getPassword())).
        role(registerbody.getRole()).build();

     userrepository.save(user);

        return  Respbodyall.builder().build();
    }

    public Respbodyall login(loginbody loginbody){
             
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginbody.getEmail(), loginbody.getPassword()));
            
        return Respbodyall.builder().build();
        
    } 
    public Respbodyall ADDvideo(Video video){
          if(video.getAvailibilty()==null){
            video.setAvailibilty(Availibilty.AVAILABLE);
          }
             
           Video video2=Video.builder().Title(video.getTitle()).Genre(video.getGenre())
           .availibilty(video.getAvailibilty()).build();
           
          videoRepository.save(video2);
            
        return Respbodyall.builder().build();
        
    } 
}
