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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "id_number")
    private String idNum;

    @Column(name = "cellphone_number", nullable = false)
    private String cellphoneNum;

    @Column(name = "email", nullable = false)
    private String email;

@Column(name = "password", nullable = false)
    private String password;

    
}
