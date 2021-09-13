package com.experimentalsoftwares.depInJava.utils.classBuilders.abstracts;

import com.experimentalsoftwares.depInJava.utils.exceptions.ClassBuildException;

import java.lang.reflect.InvocationTargetException;
import java.util.function.Supplier;

public interface ClassBuilder {
    /**
     *
     * @param cls The class of the instance will bi created
     * @param <T> The reference type of the new instance
     * @return A new, non null instance of given class
     */
    <T> T build(Class<T> cls) throws ClassBuildException;

    /**
     *
     * @param cls The class of the instance will bi created
     * @param deps The dependencies of class
     * @param <T> The reference type of the new instance
     * @return A new, non null instance of given class
     */
    <T> T build(Class<T> cls, Supplier<Object[]> deps) throws  ClassBuildException;
}
