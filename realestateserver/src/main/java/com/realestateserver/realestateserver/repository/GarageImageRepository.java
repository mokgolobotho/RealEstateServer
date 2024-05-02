package com.realestateserver.realestateserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.realestateserver.realestateserver.entity.GarageImages;

public interface GarageImageRepository extends JpaRepository<GarageImages, Long> {

}
