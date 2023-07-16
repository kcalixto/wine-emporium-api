package com.wineemporium.utils;

public class Validate {

    private ValidationResult[] errors;

    public Validate() {
        this.errors = new ValidationResult[0];
    }

    public void add(String field, String message) {
        ValidationResult[] newErrors = new ValidationResult[this.errors.length + 1];

        for (int i = 0; i < this.errors.length; i++) {
            newErrors[i] = this.errors[i];
        }

        newErrors[this.errors.length] = new ValidationResult(field, message);

        this.errors = newErrors;
    }

    public String pop() {
        return this.errors[this.errors.length - 1].getMessage();
    }

    public boolean isValid() {
        return this.errors.length == 0;
    }

}
