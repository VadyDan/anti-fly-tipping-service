package com.afts.antiflytippingservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class NullDumpException extends ResponseStatusException {
    public NullDumpException() {
        super(HttpStatus.BAD_REQUEST, "Incorrect detection date");
    }
}
