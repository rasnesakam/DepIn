package com.experimentalsoftwares.depInJava.utils.builders.abstracts;

public interface InstanceBuilder {
    <T> T build(Class<T> cls,Object[] dependencies);
    <T> T build(Class<T> cls);
}
