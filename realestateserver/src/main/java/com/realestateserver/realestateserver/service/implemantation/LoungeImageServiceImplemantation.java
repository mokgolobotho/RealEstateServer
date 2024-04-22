package com.realestateserver.realestateserver.service.implemantation;

import java.util.List;
import java.util.stream.Collectors;

import com.realestateserver.realestateserver.dto.LoungeImagesDto;
import com.realestateserver.realestateserver.entity.LoungeImages;
import com.realestateserver.realestateserver.exception.ResourceNotFoundException;
import com.realestateserver.realestateserver.mapper.LoungeImagesMapper;
import com.realestateserver.realestateserver.repository.LoungeImageRepository;
import com.realestateserver.realestateserver.service.LoungeImageService;
import org.springframework.stereotype.Service;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class LoungeImageServiceImplemantation implements LoungeImageService {

    private LoungeImageRepository loungeImageRepository;
    @Override
    public void saveLoungeImagePath(Long id, String [] paths) {
        LoungeImages loungeImages = new LoungeImages(id, paths[0], paths[1], paths[2],paths[3], paths[4]);
        loungeImageRepository.save(loungeImages);
    }

    @Override
    public LoungeImagesDto getLoungeImageById(Long id) {
        LoungeImages image = loungeImageRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Image not found with id: " + id));
        return LoungeImagesMapper.LoungeImagesToLoungeImagesDto(image);
    }

    @Override
    public List<LoungeImagesDto> getAllLoungeImages() {
        List<LoungeImages> images = loungeImageRepository.findAll();
        return images.stream()
                .map((loungeImages) -> LoungeImagesMapper.LoungeImagesToLoungeImagesDto(loungeImages))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteLoungeImageById(Long id) {
        if (!loungeImageRepository.existsById(id)) {
            throw new ResourceNotFoundException("Image not found with id: " + id);
        }
        loungeImageRepository.deleteById(id);
    }

}
