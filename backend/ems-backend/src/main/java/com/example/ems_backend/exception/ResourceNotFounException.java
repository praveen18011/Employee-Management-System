package com.example.ems_backend.exception;

public class ResourceNotFounException extends RuntimeException{
    public ResourceNotFounException(String message){
        super(message);
    }
}
