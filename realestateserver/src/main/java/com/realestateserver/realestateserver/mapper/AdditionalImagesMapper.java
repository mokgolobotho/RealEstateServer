package com.realestateserver.realestateserver.mapper;

import com.realestateserver.realestateserver.dto.AdditionalImagesDto;
import com.realestateserver.realestateserver.entity.AdditionalImages;

public class AdditionalImagesMapper {

    public static AdditionalImagesDto AdditionalImagesToAdditionalImagesDto(AdditionalImages additionalImages) {
        return new AdditionalImagesDto(
            additionalImages.getId(),
            additionalImages.getAdditional1(),
            additionalImages.getAdditional2(),
            additionalImages.getAdditional3(),
            additionalImages.getAdditional4(),
            additionalImages.getAdditional5());
    }

    public static AdditionalImages AdditionalImagesDtoToAdditionalImages(AdditionalImagesDto additionalImagesDto) {
        return new AdditionalImages(
            additionalImagesDto.getId(),
            additionalImagesDto.getAdditional1(),
            additionalImagesDto.getAdditional2(),
            additionalImagesDto.getAdditional3(),
            additionalImagesDto.getAdditional4(),
            additionalImagesDto.getAdditional5());
    }
}
