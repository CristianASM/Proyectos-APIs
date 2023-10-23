package com.integrador.proyecto01.Exceptions;

public class FormNotFoundException extends RuntimeException{
    public FormNotFoundException(String message){
        super(message);
    }
}
