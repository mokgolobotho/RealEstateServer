package com.realestateserver.realestateserver.service.implemantation;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.realestateserver.realestateserver.dto.PropertyDto;
import com.realestateserver.realestateserver.entity.Property;
import com.realestateserver.realestateserver.exception.ResourceNotFoundException;
import com.realestateserver.realestateserver.mapper.PropertyMapper;
import com.realestateserver.realestateserver.repository.PropertyRepository;
import com.realestateserver.realestateserver.service.PropertyService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PropertyServiceImpl6emantation implements PropertyService {

    private PropertyRepository propertyRepo;
    @Override
    public PropertyDto createProperty(PropertyDto propertyDto) {
        Property property = PropertyMapper.mapToProperty(propertyDto);
        Property saveAdProperty = propertyRepo.save(property);
        return PropertyMapper.mapToPropertyDto(saveAdProperty);
    }
    @Override
    public PropertyDto getPropertyById(Long propertyId) {
        Property property = propertyRepo.findById(propertyId)
            .orElseThrow(() -> new ResourceNotFoundException("Property not found with id: " + propertyId));
        return PropertyMapper.mapToPropertyDto(property);
       }
    @Override
    public List<PropertyDto> getAllProperties() {
        List<Property> properties = propertyRepo.findAll();
        return properties.stream().map((property) -> PropertyMapper.mapToPropertyDto(property))
            .collect(Collectors.toList());
    }
    @Override
    public PropertyDto updateProperty(Long PropertyId, PropertyDto updateProperty) {
    Property property = propertyRepo.findById(PropertyId).
        orElseThrow(() -> new ResourceNotFoundException("Property not found with id: " + PropertyId));
        property.setPropertyName(updateProperty.getPropertyName());
        property.setPrice(updateProperty.getPrice());
        property.setStatus(updateProperty.getStatus());
       
        Property updatedPropertyObj = propertyRepo.save(property);
        return PropertyMapper.mapToPropertyDto(updatedPropertyObj);
    }
    @Override
    public void deleteProperty(Long propertyId) {
        Property property = propertyRepo.findById(propertyId).
        orElseThrow(() -> new ResourceNotFoundException("Property not found with id: " + propertyId));
        propertyRepo.deleteById(propertyId);
        }

}
