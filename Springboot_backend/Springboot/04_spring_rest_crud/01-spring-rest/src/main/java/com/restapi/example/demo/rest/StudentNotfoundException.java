package com.restapi.example.demo.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class StudentNotfoundException extends RuntimeException
{
    public StudentNotfoundException(String message) {
        super(message);
    }

    public StudentNotfoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public StudentNotfoundException(Throwable cause) {
        super(cause);
    }


}
