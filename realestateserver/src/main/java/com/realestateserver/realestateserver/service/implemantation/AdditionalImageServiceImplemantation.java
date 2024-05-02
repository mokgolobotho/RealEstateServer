package com.realestateserver.realestateserver.service.implemantation;

import java.util.List;
import java.util.stream.Collectors;

import com.realestateserver.realestateserver.dto.AdditionalImagesDto;
import com.realestateserver.realestateserver.entity.AdditionalImages;
import com.realestateserver.realestateserver.exception.ResourceNotFoundException;
import com.realestateserver.realestateserver.mapper.AdditionalImagesMapper;
import com.realestateserver.realestateserver.repository.AdditionalImageRepository;
import com.realestateserver.realestateserver.service.AdditionalImageService;
import org.springframework.stereotype.Service;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AdditionalImageServiceImplemantation implements AdditionalImageService {

    private AdditionalImageRepository additionalImageRepository;
    @Override
    public void saveAdditionalImagePath(Long id, String [] paths) {
        AdditionalImages additionalImages = new AdditionalImages(id, paths[0], paths[1], paths[2],paths[3], paths[4]);
        additionalImageRepository.save(additionalImages);
    }

    @Override
    public AdditionalImagesDto getAdditionalImageById(Long id) {
        AdditionalImages image = additionalImageRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Image not found with id: " + id));
        return AdditionalImagesMapper.AdditionalImagesToAdditionalImagesDto(image);
    }

    @Override
    public List<AdditionalImagesDto> getAllAdditionalImages() {
        List<AdditionalImages> images = additionalImageRepository.findAll();
        return images.stream()
                .map((additionalImages) -> AdditionalImagesMapper.AdditionalImagesToAdditionalImagesDto(additionalImages))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteAdditionalImageById(Long id) {
        if (!additionalImageRepository.existsById(id)) {
            throw new ResourceNotFoundException("Image not found with id: " + id);
        }
        additionalImageRepository.deleteById(id);
    }

}
