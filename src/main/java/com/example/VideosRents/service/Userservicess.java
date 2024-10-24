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

     @Autowired
     JWTService jwtService;


    public Respbodyall register(Registerbody registerbody){
        if(registerbody.getRole()==null){
            registerbody.setRole(Role.USER);
        }

        User user=User.builder().name(registerbody.getName())
        .email(registerbody.getEmail()).password(passwordEncoder.encode(registerbody.getPassword())).
        role(registerbody.getRole()).build();



     userrepository.save(user);

     String jwt=jwtService.generateToken(user);

        return  Respbodyall.builder().token(jwt).build();
    }

    public Respbodyall login(loginbody loginbody){
             
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginbody.getEmail(), loginbody.getPassword()));
        User user=userrepository.findByEmail(loginbody.getEmail());
        String token=jwtService.generateToken(user);
            
        return Respbodyall.builder().token(token).build();
        
    } 
    public Respbodyall ADDvideo(Video video) {
        if (video.getAvailability() == null) { // Using corrected field name
            video.setAvailability(Availibilty.AVAILABLE);
        }
    
        // Build the Video object using lowercase field names
        Video video2 = Video.builder()
                .title(video.getTitle()) // Correct lowercase method
                .genre(video.getGenre()) // Correct lowercase method
                .availability(video.getAvailability()) // Correct lowercase method
                .build();
    
        videoRepository.save(video2);
    
        return Respbodyall.builder().build();
    }
    
}
