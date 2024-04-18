package com.realestateserver.realestateserver.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PutMapping;
import com.realestateserver.realestateserver.dto.AddressDto;
import com.realestateserver.realestateserver.service.AddressService;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/addresses")
public class AddressController {

    private AddressService addressService;

    //Add Addresss REST api
    @PostMapping
    public ResponseEntity<AddressDto> createAddress(@RequestBody AddressDto addressDto){
        AddressDto savedDto = addressService.createAddress(addressDto);
        return new ResponseEntity<>(savedDto, HttpStatus.CREATED);
        
    }

    //Get Addresss REST api
    @GetMapping("{id}")
    public ResponseEntity<AddressDto> getAddressById(@PathVariable("id") Long addressId){
        AddressDto addressDto = addressService.getAddressById(addressId);
        return ResponseEntity.ok(addressDto);
    }

    //get all Addresss Rest api
    @GetMapping
    public ResponseEntity<List<AddressDto>> getAllAddresss(){
        List<AddressDto> addresss = addressService.getAllAddresses();
        return ResponseEntity.ok(addresss);
    }

    //Update Address Rest api
    @PutMapping("{id}")
    public ResponseEntity<AddressDto> updateAddress(@PathVariable("id") Long addressId,@RequestBody  AddressDto updatedAddress){
        AddressDto addressDto = addressService.updateAddress(addressId, updatedAddress);
        return ResponseEntity.ok(addressDto);
    }

    //delete Address Rest API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteAddress(@PathVariable ("id") Long addressId){
        addressService.deleteAddress(addressId);
        return ResponseEntity.ok("Address deleted successfully");
    }
}
