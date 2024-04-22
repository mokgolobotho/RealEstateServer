package com.realestateserver.realestateserver.service.implemantation;

import java.util.List;
import java.util.stream.Collectors;

import com.realestateserver.realestateserver.dto.GarageImagesDto;
import com.realestateserver.realestateserver.entity.GarageImages;
import com.realestateserver.realestateserver.exception.ResourceNotFoundException;
import com.realestateserver.realestateserver.mapper.GarageImagesMapper;
import com.realestateserver.realestateserver.repository.GarageImageRepository;
import com.realestateserver.realestateserver.service.GarageImageService;
import org.springframework.stereotype.Service;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class GarageImageServiceImplemantation implements GarageImageService {

    private GarageImageRepository garageImageRepository;
    @Override
    public void saveGarageImagePath(Long id, String [] paths) {
        GarageImages garageImages = new GarageImages(id, paths[0], paths[1], paths[2],paths[3], paths[4]);
        garageImageRepository.save(garageImages);
    }

    @Override
    public GarageImagesDto getGarageImageById(Long id) {
        GarageImages image = garageImageRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Image not found with id: " + id));
        return GarageImagesMapper.GarageImagesToGarageImagesDto(image);
    }

    @Override
    public List<GarageImagesDto> getAllGarageImages() {
        List<GarageImages> images = garageImageRepository.findAll();
        return images.stream()
                .map((garageImages) -> GarageImagesMapper.GarageImagesToGarageImagesDto(garageImages))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteGarageImageById(Long id) {
        if (!garageImageRepository.existsById(id)) {
            throw new ResourceNotFoundException("Image not found with id: " + id);
        }
        garageImageRepository.deleteById(id);
    }

}
