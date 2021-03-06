package com.experimentalsoftwares.depInJava.core;

import com.experimentalsoftwares.depInJava.utils.builders.FieldInjector;
import com.experimentalsoftwares.depInJava.utils.builders.InstanceCreator;
import com.experimentalsoftwares.depInJava.utils.builders.SetterInjector;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

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
    @Contract(value = "_ -> new", pure = true)
    public static <C> @NotNull InstanceBuilder<C> init(Class<C> clss){
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
        T instance = new InstanceCreator<T>()
                .withClass(cls)
                .withArgs(deps)
                .create();
        if (fields != null){
            new FieldInjector()
                    .withInstance(instance)
                    .withMap(fields)
                    .inject();
        }
        if (setters != null){
            new SetterInjector()
                    .withInstance(instance)
                    .withMap(setters)
                    .inject();
        }
        return instance;
    }
}
