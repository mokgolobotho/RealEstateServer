package com.realestateserver.realestateserver.service;

import java.util.List;

import com.realestateserver.realestateserver.dto.AdditionalImagesDto;

public interface AdditionalImageService {

    void saveAdditionalImagePath(Long id, String [] paths);

    AdditionalImagesDto getAdditionalImageById(Long id);

    List<AdditionalImagesDto> getAllAdditionalImages();

    void deleteAdditionalImageById(Long id);
}
