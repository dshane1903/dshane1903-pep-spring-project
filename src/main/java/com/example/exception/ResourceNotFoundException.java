package com.example.exception;

public class ResourceNotFoundException extends Exception {

    public ResourceNotFoundException(){
        super("This resource does not exist.");
    }

    public ResourceNotFoundException(String message){
        super(message);
    }
    
}
