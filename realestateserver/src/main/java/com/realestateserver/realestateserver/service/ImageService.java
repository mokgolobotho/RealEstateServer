package com.realestateserver.realestateserver.service;

import com.realestateserver.realestateserver.dto.ImageDto;
import java.util.List;


public interface ImageService {

    void saveImagePath(String filePath);

    ImageDto getImageById(Long id);

    List<ImageDto> getAllImages();

    void deleteImageById(Long id);
}
