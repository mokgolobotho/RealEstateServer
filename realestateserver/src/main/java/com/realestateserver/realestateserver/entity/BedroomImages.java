package com.realestateserver.realestateserver.entity;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name ="Bedroom_Images")
public class BedroomImages {
    @Id
    private Long id;


    @Column(nullable = false)
    private String bedroom1;

    @Column
    private String bedroom2;

    @Column
    private String bedroom3;

    @Column
    private String bedroom4;

    @Column
    private String bedroom5;

  

}
