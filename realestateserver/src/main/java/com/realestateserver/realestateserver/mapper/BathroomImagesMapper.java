package com.realestateserver.realestateserver.mapper;

import com.realestateserver.realestateserver.dto.BathroomImagesDto;
import com.realestateserver.realestateserver.entity.BathroomImages;

public class BathroomImagesMapper {

    public static BathroomImagesDto BathroomImagesToBathroomImagesDto(BathroomImages bathroomImages) {
        return new BathroomImagesDto(
            bathroomImages.getId(),
            bathroomImages.getBathroom1(),
            bathroomImages.getBathroom2(),
            bathroomImages.getBathroom3(),
            bathroomImages.getBathroom4(),
            bathroomImages.getBathroom5());
    }

    public static BathroomImages BathroomImagesDtoToBathroomImages(BathroomImagesDto bathroomImagesDto) {
        return new BathroomImages(
            bathroomImagesDto.getId(),
            bathroomImagesDto.getBathroom1(),
            bathroomImagesDto.getBathroom2(),
            bathroomImagesDto.getBathroom3(),
            bathroomImagesDto.getBathroom4(),
            bathroomImagesDto.getBathroom5());
    }
}
