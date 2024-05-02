package com.realestateserver.realestateserver.service.implemantation;

import com.realestateserver.realestateserver.service.AddressService;

import lombok.AllArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.realestateserver.realestateserver.dto.AddressDto;
import com.realestateserver.realestateserver.entity.Address;
import com.realestateserver.realestateserver.exception.ResourceNotFoundException;
import com.realestateserver.realestateserver.mapper.AddressMapper;
import com.realestateserver.realestateserver.repository.AddressRepository;

@Service
@AllArgsConstructor
public class AddressServiceImplemantation implements AddressService{

    private AddressRepository addressRepo;
    @Override
    public AddressDto createAddress(AddressDto addressDto) {
        Address address = AddressMapper.mapToAddress(addressDto);
        Address saveAdAddress = addressRepo.save(address);
        return AddressMapper.mapToAddressDto(saveAdAddress);
    }
    @Override
    public AddressDto getAddressById(Long addressId) {
        Address address = addressRepo.findById(addressId)
            .orElseThrow(() -> new ResourceNotFoundException("Address not found with id: " + addressId));
        return AddressMapper.mapToAddressDto(address);
       }
    @Override
    public List<AddressDto> getAllAddresses() {
        List<Address> addresses = addressRepo.findAll();
        return addresses.stream().map((address) -> AddressMapper.mapToAddressDto(address))
            .collect(Collectors.toList());
    }
    @Override
    public AddressDto updateAddress(Long addressId, AddressDto updateAddress) {
    Address address = addressRepo.findById(addressId).
        orElseThrow(() -> new ResourceNotFoundException("Address not found with id: " + addressId));
        address.setAddrLine1(updateAddress.getAddrLine1());
        address.setAddrLine2(updateAddress.getAddrLine2());
        address.setSuburb(updateAddress.getSuburb());
        address.setCity(updateAddress.getCity());
        address.setProvence(updateAddress.getProvence());
        address.setPostalCode(updateAddress.getPostalCode());
        address.setCountry(updateAddress.getCountry());
        

        Address updatedAddressObj = addressRepo.save(address);
        return AddressMapper.mapToAddressDto(updatedAddressObj);
    }
    @Override
    public void deleteAddress(Long addressId) {
        Address address = addressRepo.findById(addressId).
        orElseThrow(() -> new ResourceNotFoundException("Address not found with id: " + addressId));
       addressRepo.deleteById(addressId);
        }

}
