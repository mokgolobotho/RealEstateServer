package com.realestateserver.realestateserver.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name ="Images")
public class Image {

    
    @Id
    private Long id;


    @Column(nullable = false)
    private String path;

    public Image(String path) {
        this.path = path;
    }

}
