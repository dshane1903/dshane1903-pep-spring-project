package com.example.exception;

public class AccountIsNullException extends Exception {
    
    public AccountIsNullException() {
        super("Error: This account is null.");
    }

    public AccountIsNullException(String message) {
        super(message);
    }
}
