package com.beybladereview.api.exceptions;

public class BeybladeNotFoundException extends RuntimeException{
    private static final long serialVersionUID = 1;

    public BeybladeNotFoundException(String message) {
        super(message);
    }
}