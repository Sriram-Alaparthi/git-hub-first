package com.example.DPS.Instiute.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Setter
@Getter
@AllArgsConstructor
public class ErrorResponse {
    private HttpStatus httpStatus;
    private String details;
    private String path;
    private String error;
}
