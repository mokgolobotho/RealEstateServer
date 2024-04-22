package com.realestateserver.realestateserver.entity;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name ="Garage_Images")
public class GarageImages {
    @Id
    private Long id;


    @Column(nullable = false)
    private String garage1;

    @Column
    private String garage2;

    @Column
    private String garage3;

    @Column
    private String garage4;

    @Column
    private String garage5;

   
}
