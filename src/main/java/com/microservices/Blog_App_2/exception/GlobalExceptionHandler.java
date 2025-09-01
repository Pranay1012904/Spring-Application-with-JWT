package com.microservices.Blog_App_2.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ExceptionObject> handleResourceNotFoundException(ResourceNotFoundException ex, WebRequest req) {
        ExceptionDetails exceptionDetails = new ExceptionDetails(
                LocalDateTime.now(),
                ex.getMessage(),
                req.getDescription(false),
                "RESOURCE_NOT_FOUND"
        );
        ExceptionObject exceptionObject = new ExceptionObject();
        exceptionObject.setSuccess(false);
        List<ExceptionDetails> exceptionDetailsList = new ArrayList<>();
        exceptionDetailsList.add(exceptionDetails);
        exceptionObject.setExceptionDetailsList(exceptionDetailsList);
        return new ResponseEntity<>(exceptionObject, HttpStatus.NOT_FOUND);
    }
}
