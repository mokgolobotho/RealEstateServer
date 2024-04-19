package com.realestateserver.realestateserver.service;

import java.util.List;

import com.realestateserver.realestateserver.dto.BathroomImagesDto;

public interface BathroomImageService {

    void saveBathroomImagePath(String [] paths);

    BathroomImagesDto getBathroomImageById(Long id);

    List<BathroomImagesDto> getAllBathroomImages();

    void deleteBathroomImageById(Long id);
}
