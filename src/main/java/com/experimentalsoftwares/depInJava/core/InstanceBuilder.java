package com.experimentalsoftwares.depInJava.core;

import com.experimentalsoftwares.depInJava.utils.exceptions.ClassBuildException;

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
        /**
         * Create instance
         * inject fields if exists
         * inject setters if exists
         */

        /*

        T instance = createInstance(deps);
        if(fields != null) injectFields(instance, fields);
        if(setters != null) injectSetters(instance, setters);
        if(instance != null){
            return instance;
        }

         */
        throw new ClassBuildException("Instance couldn't created. Couldn't find constructor annotated by Inject annotation");
    }
}
