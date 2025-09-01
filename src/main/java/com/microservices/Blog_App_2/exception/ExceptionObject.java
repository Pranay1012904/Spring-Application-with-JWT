package com.microservices.Blog_App_2.exception;

import lombok.Data;

import java.util.List;

@Data
public class ExceptionObject {

    private boolean success;
    private List<ExceptionDetails> exceptionDetailsList;

}
