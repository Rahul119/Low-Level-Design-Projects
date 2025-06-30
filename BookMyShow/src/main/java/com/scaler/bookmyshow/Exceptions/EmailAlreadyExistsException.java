package com.scaler.bookmyshow.Exceptions;

public class EmailAlreadyExistsException extends Throwable {
    public EmailAlreadyExistsException(String email) {
        super("A user with this email: " + email + "already exists");
    }
}
