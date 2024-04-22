package com.realestateserver.realestateserver.entity;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name ="Additional_Images")
public class AdditionalImages {
    @Id
    private Long id;


    @Column(nullable = false)
    private String additional1;

    @Column
    private String additional2;

    @Column
    private String additional3;

    @Column
    private String additional4;

    @Column
    private String additional5;

   

}
