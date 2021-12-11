package com.experimentalsoftwares.depInJava.utils.builders;

import com.experimentalsoftwares.depInJava.utils.annotations.Dependent;
import com.experimentalsoftwares.depInJava.utils.annotations.Inject;
import com.experimentalsoftwares.depInJava.utils.exceptions.ClassBuildException;
import com.experimentalsoftwares.depInJava.utils.exceptions.InjectionException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

public class InstanceBuilder<T> {
    private Class<T> cls;
    private Object[] deps;
    private Map<String,Object> fields;
    private Map<String,Object> setters;

    private InstanceBuilder(Class<T> cls){
        this.cls = cls;
    }

    // Chain methods
    public static <C> InstanceBuilder<C> init(Class<C> clss){
        return new InstanceBuilder<C>(clss);
    }

    public InstanceBuilder<T> withArgs(Object... deps){
        this.deps = deps;
        return this;
    }

    public InstanceBuilder<T> withFields(Map<String, Object> fields) {
        this.fields = fields;
        return this;
    }

    public InstanceBuilder<T> withSetters(Map<String, Object> setters) {
        this.setters = setters;
        return this;
    }

    public T build(){
        T instance = createInstance(deps);
        if(fields != null) injectFields(instance, fields);
        if(setters != null) injectSetters(instance, setters);
        if(instance != null){
            return instance;
        }
        throw new ClassBuildException("Instance couldn't created. Couldn't find constructor annotated by Inject annotation");
    }

    //Private methods
    private void injectFields(@NotNull Object instance,@NotNull Map<String,Object> dependencies){
        for (Field field : cls.getDeclaredFields()){
            if(field.getDeclaredAnnotation(Dependent.class) != null){
                boolean isAccessible = field.canAccess(instance);
                if(field.trySetAccessible()){
                    try {
                        Object dependent = dependencies.get(field.getName());
                        if (dependent == null) throw new InjectionException(String.format("Couldn't find dependent \"%s %s\"",field.getType().getName(),field.getName()));
                        field.set(instance,dependent);
                        if (!isAccessible) field.setAccessible(false);
                    } catch (IllegalAccessException | IllegalArgumentException e) {
                        throw new InjectionException(e.getMessage(),e);
                    }
                }
            }
        }
    }

    private void injectSetters(@NotNull Object instance, Map<String,Object> setters){
        setters.keySet().forEach(key -> {
            try {
                Method method = cls.getDeclaredMethod(key,setters.get(key).getClass());
                method.invoke(instance,setters.get(key));
            } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        });
    }

    private T createInstance(@Nullable Object... deps){
        for (Constructor<?> constructor : cls.getDeclaredConstructors()){
            if(constructor.getDeclaredAnnotation(Inject.class) != null){
                try {
                     return cls.cast(constructor.newInstance(deps));
                } catch (
                        InstantiationException
                                | IllegalArgumentException
                                | IllegalAccessException
                                | InvocationTargetException
                                | ClassCastException e
                ) {
                    throw new ClassBuildException(String.format("Instance couldn't created. %s", e.getMessage()),e);
                }
            }
        }
        try {
            Constructor<T> constructor = cls.getConstructor();
            return constructor.newInstance();
        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            throw new ClassBuildException(String.format("Instance couldn't created. %s", e.getMessage()),e);
        }
    }
}
