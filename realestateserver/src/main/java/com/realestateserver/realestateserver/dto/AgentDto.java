package com.realestateserver.realestateserver.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AgentDto {
    private Long cellphoneNum;
    private String name;
    private String surname;
    private Long idNum;
    private String email;
}
