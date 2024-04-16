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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "image_id")
    private Long imageId;

    @Column(name = "image_name")
    private String imageName;

    @Lob
    @Column(name = "image_data", length = 10000)
    private Byte[] imageData;

    @ManyToOne
    @JoinColumn(name = "property_id", nullable = false)
    private Property property;
}
