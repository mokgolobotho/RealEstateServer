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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    public BedroomImages(String bedroom1, String bedroom2, String bedroom3, String bedroom4, String bedroom5) {
        this.bedroom1 = bedroom1;
        this.bedroom2 = bedroom2;
        this.bedroom3 = bedroom3;
        this.bedroom4 = bedroom4;
        this.bedroom5 = bedroom5;
    }

}
