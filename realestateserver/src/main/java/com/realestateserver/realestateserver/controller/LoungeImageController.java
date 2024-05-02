package com.realestateserver.realestateserver.controller;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.realestateserver.realestateserver.dto.LoungeImagesDto;
import com.realestateserver.realestateserver.service.LoungeImageService;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.UUID;
import java.io.File;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/loungeimages")
public class LoungeImageController {

    private LoungeImageService loungeImageService;

@PostMapping("/{id}")
    public String uploadImages(@PathVariable Long id,@RequestParam("image") MultipartFile[] files) {
        if (files == null || files.length == 0) {
            return "No images selected";
        }

        try {
            String[] filePaths = new String[5];
            for (int i = 0; i < 5; i++) {
                if (i < files.length && files[i] != null && !files[i].isEmpty()) {
                    MultipartFile file = files[i];
                    byte[] bytes = file.getBytes();
                    String originalFilename = file.getOriginalFilename();
                    String extension = originalFilename.substring(originalFilename.lastIndexOf('.'));
                    String newFilename = UUID.randomUUID().toString() + extension;
                    String filePath = "C:/Users/Thabang/Desktop/Business/Real-Estate/Real-estate/public/images/Lounge/" + newFilename;
                    BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(filePath)));
                    stream.write(bytes);
                    stream.close();
                    filePaths[i] = newFilename;
                } else {
                    filePaths[i] = null;
                }
            }

            // Save the file paths to the database
            loungeImageService.saveLoungeImagePath(id, filePaths);

            return "Images uploaded successfully";
        } catch (IOException e) {
            e.printStackTrace();
            return "Failed to upload images";
        }
    }


    @GetMapping("/{id}")
    public ResponseEntity<LoungeImagesDto> getImageById(@PathVariable Long id) {
        LoungeImagesDto imageDto = loungeImageService.getLoungeImageById(id);
        return ResponseEntity.ok(imageDto);
    }

    @GetMapping
    public ResponseEntity<List<LoungeImagesDto>> getAllImages() {
        List<LoungeImagesDto> imageDtos = loungeImageService.getAllLoungeImages();
        return ResponseEntity.ok(imageDtos);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteImageById(@PathVariable Long id) {
        loungeImageService.deleteLoungeImageById(id);
        return ResponseEntity.noContent().build();
    }
}
