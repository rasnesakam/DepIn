package com.experimentalsoftwares.depInJava.utils.builders;

import java.util.Map;

public abstract class Injector {
    protected Map<String,Object> map;
    protected Object instance;

    public Injector withMap(Map<String,Object> map){
        this.map = map;
        return this;
    }
    public Injector withInstance(Object instance){
        this.instance = instance;
        return this;
    }
    public abstract boolean inject();
}
