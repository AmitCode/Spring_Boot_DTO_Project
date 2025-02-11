package com.springBoot.dto.exception;

import com.springBoot.dto.error.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandlerClass {
    @ExceptionHandler(UserInfoNotFoundException.class)
    public ResponseEntity<ErrorMessage> handleNoInfoFount(UserInfoNotFoundException exception, WebRequest request){
        ErrorMessage errorMessage = new ErrorMessage(
                44404,
                exception.getMessage(),
                LocalDateTime.now(),
                request.getDescription(false)
        );
        return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorMessage> handleGlobalException(Exception exception, WebRequest request){
        ErrorMessage errorMessage = new ErrorMessage(
                5500,
                exception.getMessage(),
                LocalDateTime.now(),
                request.getDescription(false)
        );
        return new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
