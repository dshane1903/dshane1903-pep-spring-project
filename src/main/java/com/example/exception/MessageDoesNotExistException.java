package com.example.exception;

public class MessageDoesNotExistException extends Exception {

    public MessageDoesNotExistException() {
        super("This message does not exist and could not be created."); 
    }

    public MessageDoesNotExistException(String message) {
        super(message);
    }
    
}
