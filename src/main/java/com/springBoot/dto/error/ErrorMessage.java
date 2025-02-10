package com.springBoot.dto.error;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorMessage {
    private int statusCode;
    private String statusMessage;
    public ErrorMessage getStatus(int statusCode){
        ErrorMessage status = new ErrorMessage();
        switch (statusCode){
            case 00:
                status.setStatusCode(0);
                status.setStatusMessage("Details Not found!...");
               break;
        }
        return status;
    }
}
