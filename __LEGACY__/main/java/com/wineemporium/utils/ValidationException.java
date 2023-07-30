package com.wineemporium.utils;

public class ValidationException extends Exception {

    private static final long serialVersionUID = 1L;

    public ValidationException(Validate v) {
        super(v.pop());
    }
}
