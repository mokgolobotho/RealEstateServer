package com.realestateserver.realestateserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.realestateserver.realestateserver.entity.Property;

public interface PropertyRepository extends JpaRepository<Property, Long> {

}
