package com.example.VideosRents.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.VideosRents.exchange.Registerbody;
import com.example.VideosRents.exchange.Respbodyall;
import com.example.VideosRents.exchange.loginbody;
import com.example.VideosRents.service.Userservicess;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class Usercontroller {
    
    @Autowired
    private  Userservicess userservicess;

    @PostMapping("/register")
    public ResponseEntity<Respbodyall> register( @RequestBody Registerbody registerbody){
          log.info("Request came");
        return ResponseEntity.ok(userservicess.register(registerbody));
    }
    @PostMapping("/login")
    public ResponseEntity<Respbodyall> rh(@RequestBody loginbody loginbody){
         log.info("Request came to login");
        return ResponseEntity.ok(userservicess.login(loginbody));
    }
}
