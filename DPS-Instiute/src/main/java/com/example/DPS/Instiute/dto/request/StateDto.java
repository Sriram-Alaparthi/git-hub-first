package com.example.DPS.Instiute.dto.request;

import com.example.DPS.Instiute.enums.Status;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StateDto {
    @NotBlank(message = "name can not null")
    private String name;
    @NotBlank(message = "status can not be null")
    private Status status;
    @NotNull(message = "countryId can not be null")
    private Long countryId;
}
