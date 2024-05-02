package com.realestateserver.realestateserver.service;

import java.util.List;

import com.realestateserver.realestateserver.dto.BedroomImagesDto;

public interface BedroomImageService {

    void saveBedroomImagePath(Long id, String [] paths);

    BedroomImagesDto getBedroomImageById(Long id);

    List<BedroomImagesDto> getAllBedroomImages();

    void deleteBedroomImageById(Long id);
}
