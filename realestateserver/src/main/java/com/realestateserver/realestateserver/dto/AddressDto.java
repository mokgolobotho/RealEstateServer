package com.realestateserver.realestateserver.dto;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddressDto {
    private Long addressId;
    private String addrLine1;
    private String addrLine2;
    private String suburb;
    private String city;
    private String provence;
    private String postalCode;
    private String country;
}
