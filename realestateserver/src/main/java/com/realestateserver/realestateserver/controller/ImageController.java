package com.realestateserver.realestateserver.controller;

import com.realestateserver.realestateserver.dto.ImageDto;
import com.realestateserver.realestateserver.service.ImageService;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.UUID;
import java.io.File;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/images")
public class ImageController {
    private ImageService imageService;


    @PostMapping("/{id}")
    public String uploadImage(@PathVariable Long id,@RequestParam("image") MultipartFile file) {
        if (file.isEmpty()) {
            return "No image selected";
        }

        try {
            byte[] bytes = file.getBytes();
            String originalFilename = file.getOriginalFilename();
            String extension = originalFilename.substring(originalFilename.lastIndexOf('.'));
            String newFilename = UUID.randomUUID().toString() + extension;
            String filePath = "C:/Users/Thabang/Desktop/Business/" + newFilename; // Set the file path where you want to save the image
            BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(filePath)));
            stream.write(bytes);
            stream.close();
            imageService.saveImagePath(id, filePath);
            return "Image uploaded successfully";
        } catch (IOException e) {
            e.printStackTrace();
            return "Failed to upload image";
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ImageDto> getImageById(@PathVariable Long id) {
        ImageDto imageDto = imageService.getImageById(id);
        return ResponseEntity.ok(imageDto);
    }

    @GetMapping
    public ResponseEntity<List<ImageDto>> getAllImages() {
        List<ImageDto> imageDtos = imageService.getAllImages();
        return ResponseEntity.ok(imageDtos);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteImageById(@PathVariable Long id) {
        imageService.deleteImageById(id);
        return ResponseEntity.noContent().build();
    }
}
