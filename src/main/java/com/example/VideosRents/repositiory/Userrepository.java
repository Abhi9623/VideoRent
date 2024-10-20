package com.example.VideosRents.repositiory;

import org.springframework.data.mongodb.repository.MongoRepository;


import com.example.VideosRents.Entitie.User;


public interface Userrepository  extends MongoRepository<User,String>{

    User findByEmail(String email);
    
}
