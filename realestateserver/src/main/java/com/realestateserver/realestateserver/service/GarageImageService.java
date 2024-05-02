package com.realestateserver.realestateserver.service;

import java.util.List;

import com.realestateserver.realestateserver.dto.GarageImagesDto;

public interface GarageImageService {

    void saveGarageImagePath(Long id, String [] paths);

    GarageImagesDto getGarageImageById(Long id);

    List<GarageImagesDto> getAllGarageImages();

    void deleteGarageImageById(Long id);
}
