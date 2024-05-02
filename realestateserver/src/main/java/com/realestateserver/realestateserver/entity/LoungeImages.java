package com.realestateserver.realestateserver.entity;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name ="Lounge_Images")
public class LoungeImages {
    @Id
    private Long id;


    @Column(nullable = false)
    private String lounge1;

    @Column
    private String lounge2;

    @Column
    private String lounge3;

    @Column
    private String lounge4;

    @Column
    private String lounge5;

    
}
