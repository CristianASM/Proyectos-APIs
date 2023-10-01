package com.api.exceptions.Exceptions;

public class EmptyListException extends RuntimeException {
    public EmptyListException(String message){
        super(message);
    }
}
