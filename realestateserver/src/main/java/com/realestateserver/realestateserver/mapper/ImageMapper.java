package com.realestateserver.realestateserver.mapper;

import com.realestateserver.realestateserver.dto.ImageDto;
import com.realestateserver.realestateserver.entity.Image;

public class ImageMapper {
    public static ImageDto imageToImageDto(Image image) {
        return new ImageDto(
            image.getId(),
            image.getPath());
    }

    public static Image imageDtoToImage(ImageDto imageDto) {
        return new Image(
            imageDto.getId(),
            imageDto.getPath());
    }
}
