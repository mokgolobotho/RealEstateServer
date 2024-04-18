package com.realestateserver.realestateserver.service;

import com.realestateserver.realestateserver.dto.ImageDto;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public interface ImageService {

    void saveImagePath(String filePath);

    ImageDto getImageById(Long id);

    List<ImageDto> getAllImages();

    void deleteImageById(Long id);
}
