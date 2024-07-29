package com.example.DPS.Instiute.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RequestDto {
    @NotNull(message = "id can not be null")
    private Long instituteId;
    @NotBlank(message = "name can not be null")
    private String name;
    @NotBlank(message = "code can not be nul")
    private String code;
    @NotBlank(message = "affiliationNO can not be null")
    private String affiliationNo;
    @NotBlank(message = "trustName can not be null")
    private String trustName;
    @NotBlank(message = "email is not null")
    private String email;
    @NotBlank(message = "phone can not be null")
    private String phone;
    @NotBlank(message = "address can not be null")
    private String address;
    private int pinCode;
    @NotNull(message = "countryId can not be null")
    private Long countryId;
    @NotNull(message = "stateId can not be null")
    private Long stateId;
    @NotBlank(message = "webSiteUrl can not be null")
    private String webSiteUrl;
}
