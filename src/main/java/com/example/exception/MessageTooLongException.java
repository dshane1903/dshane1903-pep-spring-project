package com.example.exception;

public class MessageTooLongException extends Exception {

    public MessageTooLongException(){
        super("This message is too long and cannot be created.");
    }
    public MessageTooLongException(String message) {
        super(message);
    }
}
