package com.experimentalsoftwares.depInJava.utils.builders;

public class InstanceCreator<T> {

    private Class<T> cls;
    private Object[] args;

    public InstanceCreator<T> withClass(Class<T> tClass){
        this.cls = tClass;
        return this;
    }

    public InstanceCreator<T> withArgs(Object... args){
        this.args = args;
        return this;
    }

    public T create(){
        return null;
    }
}
