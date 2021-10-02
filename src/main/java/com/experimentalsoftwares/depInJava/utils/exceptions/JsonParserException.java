package com.experimentalsoftwares.depInJava.utils.exceptions;

public class JsonParserException extends RuntimeException{
    private JsonParserException(String message, Exception e){
        super(message,e);
    }

    public static JsonParserException invalidJsonString(Exception e){
        return new JsonParserException("invalid JSON input. JSON object must be an array",e);
    }
    public static JsonParserException invalidJsonObject(Exception e){
        return new JsonParserException("Invalid JSON object. Object doesn't have requested keys",e);
    }
}
