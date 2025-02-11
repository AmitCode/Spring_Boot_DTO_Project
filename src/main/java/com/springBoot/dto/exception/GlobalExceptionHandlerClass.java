package com.springBoot.dto.exception;

import com.springBoot.dto.error.ErrorMessage;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandlerClass extends ResponseEntityExceptionHandler {
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

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers,
                                                                  HttpStatusCode status,
                                                                  WebRequest request) {
        Map<String,String> error = new HashMap<>();
        List<ObjectError> errorList = ex.getAllErrors();
        errorList.forEach((errors) ->{
            String fieldName = ((FieldError) errors).getField();
            String message = errors.getDefaultMessage();
            error.put(fieldName,message);
        });
        return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
    }
}
