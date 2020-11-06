package com.afts.antiflytippingservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class WrongDateException extends ResponseStatusException {
    public WrongDateException() {
        super(HttpStatus.BAD_REQUEST, "Incorrect detection date");
    }
}
