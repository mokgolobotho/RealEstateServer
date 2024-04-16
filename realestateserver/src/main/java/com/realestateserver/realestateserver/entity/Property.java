package com.realestateserver.realestateserver.entity;

import java.util.List;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name ="Properties")
public class Property {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "property_id")
    private Long propertyId;

    @Column(name = "property_name", nullable = false)
    private String propetyName;
    @Column(name = "property_type", nullable = false)
    private String propetyType;

    @Column(name = "price", nullable = false)
    private String price;

    @Column(name = "numOfBedRooms")
    private int numOfBedRooms;

    @Column(name = "numOfBathrooms")
    private int numOfBathrooms;

    @Column(name = "numOfGarages")
    private int numOfGarages;

    @Column(name = "numOfLounges")
    private int numOfLounges;


    @OneToMany(mappedBy = "property", cascade = CascadeType.ALL)
    private List<Image> images;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "address_id")
    private Address address;

    
}
