package com.realestateserver.realestateserver.service;

import com.realestateserver.realestateserver.dto.AddressDto;

import java.util.List;

public interface AddressService {
    AddressDto createAddress(AddressDto addressDto);

    AddressDto getAddressById(Long addressId);

    List<AddressDto> getAllAddresses();

    AddressDto updateAddress(Long addressId, AddressDto updatedAddress);

    void deleteAddress(Long addressId);
}
