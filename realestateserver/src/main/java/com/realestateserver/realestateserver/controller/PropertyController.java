package com.realestateserver.realestateserver.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.realestateserver.realestateserver.dto.PropertyDto;
import com.realestateserver.realestateserver.service.PropertyService;
import lombok.AllArgsConstructor;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/properties")
public class PropertyController {

    private PropertyService propertyService;

    //Add Property REST api
    @PostMapping
    public ResponseEntity<PropertyDto> createProperty(@RequestBody PropertyDto PropertyDto){
        PropertyDto savedDto = propertyService.createProperty(PropertyDto);
        return new ResponseEntity<>(savedDto, HttpStatus.CREATED);
        
    }

    //Get Propertys REST api
    @GetMapping("{id}")
    public ResponseEntity<PropertyDto> getPropertyById(@PathVariable("id") Long propertyId){
        PropertyDto propertyDto = propertyService.getPropertyById(propertyId);
        return ResponseEntity.ok(propertyDto);
    }

    //get all Propertys Rest api
    @GetMapping
    public ResponseEntity<List<PropertyDto>> getAllProperties(){
        List<PropertyDto> properties = propertyService.getAllProperties();
        return ResponseEntity.ok(properties);
    }

    //Update property Rest api
    @PutMapping("{id}")
    public ResponseEntity<PropertyDto> updateProperty(@PathVariable("id") Long propertyId,@RequestBody  PropertyDto updatedProperty){
        PropertyDto propertyDto = propertyService.updateProperty(propertyId, updatedProperty);
        return ResponseEntity.ok(propertyDto);
    }

    //delete Property Rest API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteProperty(@PathVariable ("id") Long propertyId){
        propertyService.deleteProperty(propertyId);
        return ResponseEntity.ok("Property deleted successfully");
    }

}
