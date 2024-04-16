package com.realestateserver.realestateserver.dto;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ImageDto {
    private Long imageId;
    private String imageName;
    private Byte[] imageData;
}
