package com.example.exception;

public class DuplicateUsernameException extends Exception {

    public DuplicateUsernameException(){
        super("This username already exists.");
    }

    public DuplicateUsernameException(String message){
        super(message);
    }
    
}