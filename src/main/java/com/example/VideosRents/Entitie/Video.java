package com.example.VideosRents.Entitie;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.example.VideosRents.enums.Availibilty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "Videos")
public class Video {
    @Id
    private String id; // Changed Id to id for consistency
    private String title; // Changed Title to title
    private String genre; // Changed Genre to genre
    private Availibilty availability; // Fixed spelling from availibilty to availability
}
