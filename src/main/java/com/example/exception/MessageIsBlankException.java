package com.example.exception;

public class MessageIsBlankException extends Exception {
    public MessageIsBlankException() {
        super("The account that posted this message does not exist.");
    }

    public MessageIsBlankException(String message) {
        super(message);
    }
}
