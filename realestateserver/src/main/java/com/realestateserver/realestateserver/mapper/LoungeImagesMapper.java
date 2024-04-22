package com.realestateserver.realestateserver.mapper;

import com.realestateserver.realestateserver.dto.LoungeImagesDto;
import com.realestateserver.realestateserver.entity.LoungeImages;

public class LoungeImagesMapper {

    public static LoungeImagesDto LoungeImagesToLoungeImagesDto(LoungeImages loungeImages) {
        return new LoungeImagesDto(
            loungeImages.getId(),
            loungeImages.getLounge1(),
            loungeImages.getLounge2(),
            loungeImages.getLounge3(),
            loungeImages.getLounge4(),
            loungeImages.getLounge5());
    }

    public static LoungeImages LoungeImagesDtoToLoungeImages(LoungeImagesDto loungeImagesDto) {
        return new LoungeImages(
            loungeImagesDto.getId(),
            loungeImagesDto.getLounge1(),
            loungeImagesDto.getLounge2(),
            loungeImagesDto.getLounge3(),
            loungeImagesDto.getLounge4(),
            loungeImagesDto.getLounge5());
    }
}
