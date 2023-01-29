package com.emakas.depIn.utils.exceptions;

public class ClassBuildException extends RuntimeException{

    public ClassBuildException(String message){
        super(message);
    }
    public ClassBuildException(String message,Throwable cause){
        super(message,cause);
    }

}
