package com.realestateserver.realestateserver.service;

import com.realestateserver.realestateserver.dto.PropertyDto;

import java.util.List;

public interface PropertyService {
    PropertyDto createProperty(PropertyDto propertyDto);

    PropertyDto getPropertyById(Long propertyId);

    List<PropertyDto> getAllProperties();

    PropertyDto updateProperty(Long propertyId, PropertyDto updatedProperty);

    void deleteProperty(Long propertyId);
}
