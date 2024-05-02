package com.realestateserver.realestateserver.entity;

import jakarta.persistence.*;
import lombok.*;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name ="Properties")
public class Property {

    @Id
    @Column(name = "property_id")
    private Long propertyId;

    @Column(name = "property_name", nullable = false)
    private String propertyName;

    @Column(name = "property_type", nullable = false)
    private String propertyType;

    @Column(name = "price", nullable = false)
    private String price;

    @Column(name = "status", nullable = false)
    private String status;

    @Column(name = "numOfBedRooms")
    private int numOfBedRooms;

    @Column(name = "numOfBathrooms")
    private int numOfBathrooms;

    @Column(name = "numOfGarages")
    private int numOfGarages;

    @Column(name = "numOfLounges")
    private int numOfLounges;

}
