package com.example.DPS.Instiute.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
public class ResourceAlreayExistsException extends RuntimeException{
    public ResourceAlreayExistsException(String msg){
        super(msg);
    }
}
