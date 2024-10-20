package com.example.VideosRents.repositiory;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.VideosRents.Entitie.Video;

public interface VideoRepository extends MongoRepository<Video,String> {
    
}
