package com.realestateserver.realestateserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.realestateserver.realestateserver.entity.Image;

public interface StorageRepository extends JpaRepository<Image, Long>{

}
