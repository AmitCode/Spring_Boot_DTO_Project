package com.springBoot.dto.error;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ErrorMessage {
    private int statusCode;
    private String statusMessage;
    private LocalDateTime timeStamp;
    private String path;
    public String getStatus(int statusCode){
        String message="";
        switch (statusCode){
            case 4404:
                //status.setStatusCode(0);
                message = "Details Not found!...";
               break;
        }
        return message;
    }
}
