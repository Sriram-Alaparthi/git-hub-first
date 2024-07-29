package com.example.DPS.Instiute.dto.request;

import com.example.DPS.Instiute.enums.Status;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CountryDto {
    @NotBlank(message = "name can not be null")
    private String name;
    private Status status;
}
