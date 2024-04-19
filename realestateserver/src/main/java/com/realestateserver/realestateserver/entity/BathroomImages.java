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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    public BathroomImages(String bathroom1, String bathroom2, String bathroom3, String bathroom4, String bathroom5) {
        this.bathroom1 = bathroom1;
        this.bathroom2 = bathroom2;
        this.bathroom3 = bathroom3;
        this.bathroom4 = bathroom4;
        this.bathroom5 = bathroom5;
    }

}
