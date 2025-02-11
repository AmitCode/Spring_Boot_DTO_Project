package com.springBoot.dto.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class UserInfoNotFoundException extends RuntimeException{
    private String infoName;
    private String fieldName;
    private long fieldValue;
    public UserInfoNotFoundException(String infoName, String fieldName, long fieldValue){
        super(String.format("%s not found with %s: '%s'",infoName,fieldName,fieldValue));
        this.infoName = infoName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }
}
