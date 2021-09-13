package com.experimentalsoftwares.depInJava.utils.exceptions;

public class ClassBuildException extends Exception{

    public ClassBuildException(String message){
        super(message);
    }
    public ClassBuildException(String message,Throwable cause){
        super(message,cause);
    }

}
