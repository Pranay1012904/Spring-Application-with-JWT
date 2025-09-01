package com.microservices.Blog_App_2.exception;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ExceptionDetails {
    public ExceptionDetails(LocalDateTime timeStamp, String message, String description, String errorCode) {
        this.timeStamp = timeStamp;
        this.message = message;
        this.description = description;
        this.errorCode = errorCode;
    }

    private LocalDateTime timeStamp;
    private String message;
    private String description;
    private String errorCode;
}
