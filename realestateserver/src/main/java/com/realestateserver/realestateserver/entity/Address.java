package com.realestateserver.realestateserver.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name ="Addressess")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id")
    private Long addressId;

    @Column(name = "addr_line1", nullable = false)
    private String addrLine1;

    @Column(name = "addr_line2")
    private String addrLine2;

    @Column(name = "suburb", nullable = false)
    private String suburb;

    @Column(name = "city", nullable = false)
    private String city;

    @Column(name = "provence", nullable = false)
    private String provence;

    @Column(name = "postal_code", nullable = false)
    private String postalCode;

    @Column(name = "country", nullable = false)
    private String country;

    @OneToOne(mappedBy = "address")
    private Property property;
}
