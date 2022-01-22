package com.experimentalsoftwares.depInJava.core;

import com.experimentalsoftwares.depInJava.utils.exceptions.ClassBuildException;
import com.experimentalsoftwares.depInJava.utils.mappers.maps.ClassMaps;
import com.experimentalsoftwares.depInJava.utils.mappers.keys.json.JsonClassMaps;
import org.jetbrains.annotations.NotNull;

import java.io.File;

public class ClassMapContext {
    private static final String
            JSON = ".json"
            ,XML = ".xml";
    private ClassMaps maps;

    private ClassMapContext(){}

    public static @NotNull ClassMapContext loadWithContextFile(@NotNull File mapFile){
        ClassMapContext classMapContext = new ClassMapContext();
        String fileName = mapFile.getName();
        String extension = fileName.substring(fileName.lastIndexOf("."),fileName.length()-1);
        switch (extension){
            case JSON -> classMapContext.maps = new JsonClassMaps(mapFile.getAbsolutePath());
            case XML -> classMapContext.maps = null;
            default -> throw new ClassBuildException("Given file is unsupported");
        }
        return classMapContext;
    }

    public <T> T getInstance(String name){
        return null;
    }
}
