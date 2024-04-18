package com.realestateserver.realestateserver.service.implemantation;

import java.util.List;
import java.util.stream.Collectors;

import com.realestateserver.realestateserver.dto.BedroomImagesDto;
import com.realestateserver.realestateserver.entity.BedroomImages;
import com.realestateserver.realestateserver.exception.ResourceNotFoundException;
import com.realestateserver.realestateserver.mapper.BedroomImagesMapper;
import com.realestateserver.realestateserver.repository.BedroomImageRepository;
import com.realestateserver.realestateserver.service.BedroomImageService;
import org.springframework.stereotype.Service;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BedroomImageServiceImplemantation implements BedroomImageService {

    private BedroomImageRepository bedrooomimageRepository;
    @Override
    public void saveBedroomImagePath(String [] paths) {
        BedroomImages bedroomImages = new BedroomImages(paths[0], paths[1], paths[2],paths[3], paths[4]);
        bedrooomimageRepository.save(bedroomImages);
    }

    @Override
    public BedroomImagesDto getBedroomImageById(Long id) {
        BedroomImages image = bedrooomimageRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Image not found with id: " + id));
        return BedroomImagesMapper.BedroomImagesToBedroomImagesDto(image);
    }

    @Override
    public List<BedroomImagesDto> getAllBedroomImages() {
        List<BedroomImages> images = bedrooomimageRepository.findAll();
        return images.stream()
                .map((bedroomImages) -> BedroomImagesMapper.BedroomImagesToBedroomImagesDto(bedroomImages))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteBedroomImageById(Long id) {
        if (!bedrooomimageRepository.existsById(id)) {
            throw new ResourceNotFoundException("Image not found with id: " + id);
        }
        bedrooomimageRepository.deleteById(id);
    }

}
