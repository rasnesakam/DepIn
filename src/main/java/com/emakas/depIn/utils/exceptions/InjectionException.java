package com.emakas.depIn.utils.exceptions;

public class InjectionException extends RuntimeException{
    public InjectionException(String message) {
        super(message);
    }

    public InjectionException(String message, Throwable cause) {
        super(message, cause);
    }
}
