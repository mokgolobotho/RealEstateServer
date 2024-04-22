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
    private String idNum;
    private String cellphoneNum;
    private String email;
    private String password;
}
