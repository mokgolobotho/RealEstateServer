package com.realestateserver.realestateserver.mapper;

import com.realestateserver.realestateserver.dto.AddressDto;
import com.realestateserver.realestateserver.entity.Address;

public class AddressMapper {

    public static AddressDto mapToAddressDto(Address address){
        return new AddressDto(
            address.getAddressId(),
            address.getAddrLine1(),
            address.getAddrLine2(),
            address.getSuburb(),
            address.getCity(),
            address.getProvence(),
            address.getPostalCode(),
            address.getCountry()
        );
    }

    public static Address mapToAddress(AddressDto addressDto){
        return new Address(
            addressDto.getAddressId(),
            addressDto.getAddrLine1(),
            addressDto.getAddrLine2(),
            addressDto.getSuburb(),
            addressDto.getCity(),
            addressDto.getProvence(),
            addressDto.getPostalCode(),
            addressDto.getCountry()
        );
    
    }
}
