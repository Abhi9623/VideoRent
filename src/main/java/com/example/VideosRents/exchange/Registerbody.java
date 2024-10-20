package com.example.VideosRents.exchange;

import com.example.VideosRents.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Registerbody {
    
    private String name;
    private String email;
    private String password;
     private Role role;
    
} 