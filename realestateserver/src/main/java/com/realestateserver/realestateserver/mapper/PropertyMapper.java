package com.realestateserver.realestateserver.mapper;

import com.realestateserver.realestateserver.dto.PropertyDto;
import com.realestateserver.realestateserver.entity.Property;

public class PropertyMapper {

    public static PropertyDto mapToPropertyDto(Property property){
        return new PropertyDto(
            property.getPropertyId(),
            property.getPropertyName(),
            property.getPropertyType(),
            property.getPrice(),
            property.getStatus(),
            property.getNumOfBedRooms(),
            property.getNumOfBathrooms(),
            property.getNumOfGarages(),
            property.getNumOfLounges());
    }
    public static Property mapToProperty(PropertyDto propertyDto){
        return new Property(
            propertyDto.getPropertyId(),
            propertyDto.getPropertyName(),
            propertyDto.getPropertyType(),
            propertyDto.getPrice(),
            propertyDto.getStatus(),
            propertyDto.getNumOfBedRooms(),
            propertyDto.getNumOfBathrooms(),
            propertyDto.getNumOfGarages(),
            propertyDto.getNumOfLounges()
        );
    }
}
