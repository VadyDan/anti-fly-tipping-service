package com.afts.antiflytippingservice.exception;

import org.springframework.boot.web.server.WebServerException;

public class ValidationException extends Exception {
    private String message;

    public ValidationException(String message) {
    }

    public String getMessage() {
        return message;
    }
}
