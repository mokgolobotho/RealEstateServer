package com.realestateserver.realestateserver.dto;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AdminDto {
    private Long adminId;
    private String name;
    private String surname;
    private Long idNum;
    private Long cellphoneNum;
    private String email;
}
