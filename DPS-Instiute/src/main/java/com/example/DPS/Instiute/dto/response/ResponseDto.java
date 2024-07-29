package com.example.DPS.Instiute.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResponseDto {
    private Long id;
    private String name;
    private Long instituteId;
    private String instituteName;
    private String code;
    private String affiliationNo;
    private String trustName;
    private String email;
    private String phone;
    private String address;
    private int pinCode;
    private Long countryId;
    private String countryName;
    private Long stateId;
    private String stateName;
    private String webSiteUrl;
}
