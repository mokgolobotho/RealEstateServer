package com.realestateserver.realestateserver.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name ="Admins")
public class Admin {
    @Id
    private Long adminId;

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
