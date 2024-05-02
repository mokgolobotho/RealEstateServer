package com.realestateserver.realestateserver.service;

import java.util.List;

import com.realestateserver.realestateserver.dto.LoungeImagesDto;

public interface LoungeImageService {

    void saveLoungeImagePath(Long id, String [] paths);

    LoungeImagesDto getLoungeImageById(Long id);

    List<LoungeImagesDto> getAllLoungeImages();

    void deleteLoungeImageById(Long id);
}
