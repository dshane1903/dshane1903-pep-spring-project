package com.example.exception;

public class PasswordNotLongEnoughException extends Exception {
    
    public PasswordNotLongEnoughException() {
        super("This password was not long enough and could not be registered.");
    }

    public PasswordNotLongEnoughException(String message) {
        super(message);
    }
}
