package com.realestateserver.realestateserver.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AgentDto {
    private Long id;
    private String name;
    private String surname;
    private Long idNum;
    private Long cellphoneNum;
    private String email;
}
