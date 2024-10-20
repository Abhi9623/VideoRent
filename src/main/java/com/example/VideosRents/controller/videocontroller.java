package com.example.VideosRents.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.VideosRents.Entitie.Video;
import com.example.VideosRents.exchange.Respbodyall;
import com.example.VideosRents.service.Userservicess;

@RestController
@RequestMapping("/videos")
public class videocontroller {
    
    @Autowired
    private Userservicess userservicess;
    
    @GetMapping("")
    public String videos(){
        return "all videos are here";
    }

    @PostMapping("/Add")
  @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<Respbodyall>addvideos(@RequestBody Video video){
            return ResponseEntity.ok(userservicess.ADDvideo(video));
    }

}
