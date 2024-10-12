package com.example.exception;

public class IncorrectLoginException extends Exception{

    public IncorrectLoginException(){
        super("Incorrect login credentials; login failed.");
    }

    public IncorrectLoginException(String message) {
        super(message);
    }
}
