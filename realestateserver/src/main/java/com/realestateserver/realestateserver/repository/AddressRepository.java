package com.realestateserver.realestateserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.realestateserver.realestateserver.entity.Address;

public interface AddressRepository extends JpaRepository<Address, Long>{

}
