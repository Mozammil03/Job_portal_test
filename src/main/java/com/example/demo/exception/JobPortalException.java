package com.example.demo.exception; // or your appropriate package

public class JobPortalException extends RuntimeException {

    public JobPortalException(String message) {
        super(message);
    }

    public JobPortalException(String message, Throwable cause) {
        super(message, cause);
    }
}