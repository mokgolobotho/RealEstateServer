package com.realestateserver.realestateserver.dto;
import java.util.List;
import com.realestateserver.realestateserver.entity.Address;
import com.realestateserver.realestateserver.entity.Image;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PropertyDto {
    private Long propertyId;
    private String propetyName;
    private String propetyType;
    private String price;
    private int numOfBedRooms;
    private int numOfBathrooms;
    private int numOfGarages;
    private int numOfLounges;
    private List<Image> images;
    private Address address;
}
