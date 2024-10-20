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
    private String Id;
    private String Title;
    private String Genre;
    private Availibilty availibilty;
}
