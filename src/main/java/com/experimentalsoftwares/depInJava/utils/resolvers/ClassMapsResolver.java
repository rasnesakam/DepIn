package com.experimentalsoftwares.depInJava.utils.resolvers;

import com.experimentalsoftwares.depInJava.utils.mappers.maps.ClassMap;
import com.experimentalsoftwares.depInJava.utils.mappers.maps.ClassMaps;

public class ClassMapsResolver {
    public ClassMaps maps;

    public ClassMap getClassMap(String ref){
        return null;
    }
    public <T> Class<T> getTargetClass(String ref){
        return null;
    }
    public Class[] getConstructorArgs(){
        return null;
    }
}
