package com.realestateserver.realestateserver.service.implemantation;

import java.util.List;
import java.util.stream.Collectors;

import com.realestateserver.realestateserver.dto.BathroomImagesDto;
import com.realestateserver.realestateserver.entity.BathroomImages;
import com.realestateserver.realestateserver.exception.ResourceNotFoundException;
import com.realestateserver.realestateserver.mapper.BathroomImagesMapper;
import com.realestateserver.realestateserver.repository.BathroomImageRepository;
import com.realestateserver.realestateserver.service.BathroomImageService;
import org.springframework.stereotype.Service;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BathroomImageServiceImplemantation implements BathroomImageService {

    private BathroomImageRepository bathrooomimageRepository;
    @Override
    public void saveBathroomImagePath(String [] paths) {
        BathroomImages bathroomImages = new BathroomImages(paths[0], paths[1], paths[2],paths[3], paths[4]);
        bathrooomimageRepository.save(bathroomImages);
    }

    @Override
    public BathroomImagesDto getBathroomImageById(Long id) {
        BathroomImages image = bathrooomimageRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Image not found with id: " + id));
        return BathroomImagesMapper.BathroomImagesToBathroomImagesDto(image);
    }

    @Override
    public List<BathroomImagesDto> getAllBathroomImages() {
        List<BathroomImages> images = bathrooomimageRepository.findAll();
        return images.stream()
                .map((bathroomImages) -> BathroomImagesMapper.BathroomImagesToBathroomImagesDto(bathroomImages))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteBathroomImageById(Long id) {
        if (!bathrooomimageRepository.existsById(id)) {
            throw new ResourceNotFoundException("Image not found with id: " + id);
        }
        bathrooomimageRepository.deleteById(id);
    }

}
