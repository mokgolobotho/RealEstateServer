package com.realestateserver.realestateserver.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name ="Agents")
public class Agent {

    @Id
    @Column(name = "cellphone_number", nullable = false)
    private Long cellphoneNum;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "id_number")
    private Long idNum;

    

    @Column(name = "email", nullable = false)
    private String email;

    
}
