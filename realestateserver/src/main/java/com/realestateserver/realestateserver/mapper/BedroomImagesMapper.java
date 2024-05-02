package com.realestateserver.realestateserver.mapper;

import com.realestateserver.realestateserver.dto.BedroomImagesDto;
import com.realestateserver.realestateserver.entity.BedroomImages;

public class BedroomImagesMapper {

    public static BedroomImagesDto BedroomImagesToBedroomImagesDto(BedroomImages bedroomImages) {
        return new BedroomImagesDto(
            bedroomImages.getId(),
            bedroomImages.getBedroom1(),
            bedroomImages.getBedroom2(),
            bedroomImages.getBedroom3(),
            bedroomImages.getBedroom4(),
            bedroomImages.getBedroom5());
    }

    public static BedroomImages BedroomImagesDtoToBedroomImages(BedroomImagesDto bedroomImagesDto) {
        return new BedroomImages(
            bedroomImagesDto.getId(),
            bedroomImagesDto.getBedroom1(),
            bedroomImagesDto.getBedroom2(),
            bedroomImagesDto.getBedroom3(),
            bedroomImagesDto.getBedroom4(),
            bedroomImagesDto.getBedroom5());
    }
}
