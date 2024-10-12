package com.example.exception;

public class UsernameIsBlankException extends Exception {
    
    public UsernameIsBlankException() {
        super("Error: This username is blank.");
    }

    public UsernameIsBlankException(String message) {
        super(message);
    }
}
