package com.example.exception;

public class PosterDoesNotExistException extends Exception {
    
    public PosterDoesNotExistException() {
        super("The account that posted this message does not exist.");
    }

    public PosterDoesNotExistException(String message) {
        super(message);
    }
}
