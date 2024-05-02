package com.realestateserver.realestateserver.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.realestateserver.realestateserver.entity.Property;

public interface PropertyRepository extends JpaRepository<Property, Long> {


}
