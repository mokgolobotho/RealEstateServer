package com.realestateserver.realestateserver.controller;

import com.realestateserver.realestateserver.dto.ImageDto;
import com.realestateserver.realestateserver.service.ImageService;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.io.File;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/images")
public class ImageController {
    private ImageService imageService;


    @PostMapping
    public String uploadImage(@RequestParam("image") MultipartFile file) {
        if (file.isEmpty()) {
            return "No image selected";
        }

        try {
            byte[] bytes = file.getBytes();
            String filePath = "C:/Users/Thabang/Desktop/Business/" + file.getOriginalFilename(); // Set the file path where you want to save the image
            BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(filePath)));
            stream.write(bytes);
            stream.close();
            imageService.saveImagePath(filePath);
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
