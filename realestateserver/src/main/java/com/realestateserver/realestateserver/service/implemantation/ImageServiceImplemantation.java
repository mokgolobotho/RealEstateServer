package com.realestateserver.realestateserver.service.implemantation;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.realestateserver.realestateserver.dto.ImageDto;
import com.realestateserver.realestateserver.entity.Image;
import com.realestateserver.realestateserver.exception.ResourceNotFoundException;
import com.realestateserver.realestateserver.mapper.ImageMapper;
import com.realestateserver.realestateserver.repository.ImageRepository;
import com.realestateserver.realestateserver.service.ImageService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ImageServiceImplemantation implements ImageService {

    private ImageRepository imageRepository;

    public void saveImagePath(Long id, String filePath) {
        Image imageEntity = new Image(id, filePath);
        imageRepository.save(imageEntity);
    }

    @Override
    public ImageDto getImageById(Long id) {
        Image image = imageRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Image not found with id: " + id));
        return ImageMapper.imageToImageDto(image);
    }

    @Override
    public List<ImageDto> getAllImages() {
        List<Image> images = imageRepository.findAll();
        return images.stream()
                .map((image) -> ImageMapper.imageToImageDto(image))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteImageById(Long id) {
        if (!imageRepository.existsById(id)) {
            throw new ResourceNotFoundException("Image not found with id: " + id);
        }
        imageRepository.deleteById(id);
    }
}
