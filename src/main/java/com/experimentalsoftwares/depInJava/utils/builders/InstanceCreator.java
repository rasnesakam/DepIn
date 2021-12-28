package com.experimentalsoftwares.depInJava.utils.builders;

import com.experimentalsoftwares.depInJava.utils.exceptions.ClassBuildException;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

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
        if (cls == null)
            throw new ClassBuildException("Target class must be specified");
        Constructor<T> constructor = getConstructor(args);
        try {
            return constructor.newInstance(args);
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
            String message;
            if (e instanceof InstantiationException)
                message = "Target is not instantiable.";
            else if (e instanceof IllegalAccessException)
                message = "Target class is not accessible.";
            else // InvocationTargetException
                message = "An exception thrown from invoked method. See caused exception";
            throw new ClassBuildException(message,e);
        }
    }

    private Constructor<T> getConstructor(Object[] args) {
        Class<?>[] types = args != null ? new Class<?>[args.length] : new Class<?>[0];
        for (int i = 0; i < types.length; i++)
            types[i] = args[i].getClass();
        try {
            return cls.getConstructor(types);
        } catch (NoSuchMethodException e) {
            throw new ClassBuildException(
                    "Can't find constructor with given arguments. " +
                            "Order of arguments must be same as declared in class file"
                    ,e
            );
        }
    }
}
