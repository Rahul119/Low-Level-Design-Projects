package com.scaler.bookmyshow.Exceptions;

public class InvalidCustomerException extends RuntimeException {
    public InvalidCustomerException() {
        super("Email is Mandatory");
    }
}
