package com.realestateserver.realestateserver.mapper;

import com.realestateserver.realestateserver.dto.GarageImagesDto;
import com.realestateserver.realestateserver.entity.GarageImages;

public class GarageImagesMapper {

    public static GarageImagesDto GarageImagesToGarageImagesDto(GarageImages garageImages) {
        return new GarageImagesDto(
            garageImages.getId(),
            garageImages.getGarage1(),
            garageImages.getGarage2(),
            garageImages.getGarage3(),
            garageImages.getGarage4(),
            garageImages.getGarage5());
    }

    public static GarageImages GarageImagesDtoToGarageImages(GarageImagesDto garageImagesDto) {
        return new GarageImages(
            garageImagesDto.getId(),
            garageImagesDto.getGarage1(),
            garageImagesDto.getGarage2(),
            garageImagesDto.getGarage3(),
            garageImagesDto.getGarage4(),
            garageImagesDto.getGarage5());
    }
}
