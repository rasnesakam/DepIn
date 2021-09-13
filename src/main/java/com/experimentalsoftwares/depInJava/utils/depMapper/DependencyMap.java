package com.experimentalsoftwares.depInJava.utils.depMapper;

import java.util.HashMap;
import java.util.Map;

public class DependencyMap {
    private Map<Class,Object> map;

    public DependencyMap(){
        map = new HashMap<Class,Object>();
    }

    public void putDependency(Class<?> cls, Object obj){
        if (cls.isInstance(obj)){
            map.put(cls,obj);
        }
        else throw new ClassCastException("Given object is not the instance of given class");
    }

    public Object getDependency(Class<?> cls){
        return map.get(cls);
    }
}
