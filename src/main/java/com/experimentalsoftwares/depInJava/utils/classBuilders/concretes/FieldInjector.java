package com.experimentalsoftwares.depInJava.utils.classBuilders.concretes;

import com.experimentalsoftwares.depInJava.utils.annotations.Dependent;
import com.experimentalsoftwares.depInJava.utils.classBuilders.abstracts.ClassBuilder;
import com.experimentalsoftwares.depInJava.utils.exceptions.ClassBuildException;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.Collections;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class FieldInjector implements ClassBuilder {
    @Override
    public <T> T build(Class<T> cls) throws ClassBuildException {
        return build(cls,null);
    }

    @Override
    public <T> T build(Class<T> cls, Supplier<Object[]> deps) throws  ClassBuildException {
        try {

            Constructor<T> constructor = cls.getConstructor(null);
            T instance = constructor.newInstance(null);
            for(Field f : cls.getDeclaredFields()){
                if(f.getDeclaredAnnotation(Dependent.class) != null) {
                    int i = 0;
                    setField(f,instance,deps.get()[i]);
                    i++;
                }
            }
            return instance;

        } catch (NoSuchMethodException | IllegalAccessException | InstantiationException |InvocationTargetException  e) {

            String message =
                    e instanceof NoSuchMethodException ? "Class must have empty constructor":
                            e instanceof  IllegalAccessException ? "Empty constructor must be public" :
                                    e instanceof InstantiationException ? "Class couldn't instantiated. Is this class instantiable":
                                            e instanceof  InvocationTargetException ? "Class couldn't instantiated":
                                                    "";

            throw new ClassBuildException(message,e);
        }
    }
    private void setField(Field f, Object instance, Object value) throws IllegalAccessException {
        if(f.canAccess(instance)){
           f.set(instance,value);
        }
        else {
            if(f.trySetAccessible()){
                f.set(instance,value);
                f.setAccessible(false);
            }
        }
    }
}
