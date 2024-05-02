package com.realestateserver.realestateserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.realestateserver.realestateserver.entity.Image;

public interface ImageRepository extends JpaRepository<Image, Long> {

}
