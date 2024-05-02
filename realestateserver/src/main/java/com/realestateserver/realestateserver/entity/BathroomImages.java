package com.realestateserver.realestateserver.entity;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name ="Bathroom_Images")
public class BathroomImages {
    @Id
    private Long id;


    @Column(nullable = false)
    private String bathroom1;

    @Column
    private String bathroom2;

    @Column
    private String bathroom3;

    @Column
    private String bathroom4;

    @Column
    private String bathroom5;

    

}
