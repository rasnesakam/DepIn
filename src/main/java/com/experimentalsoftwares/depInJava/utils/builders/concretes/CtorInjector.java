package com.experimentalsoftwares.depInJava.utils.builders.concretes;

import com.experimentalsoftwares.depInJava.utils.annotations.Inject;
import com.experimentalsoftwares.depInJava.utils.builders.abstracts.InstanceBuilder;
import com.experimentalsoftwares.depInJava.utils.exceptions.ClassBuildException;

import java.lang.invoke.TypeDescriptor;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class CtorInjector implements InstanceBuilder {
    @Override
    public <T> T build(Class<T> cls, Object[] dependencies) {
        for(Constructor ctor : cls.getConstructors()){
            if (ctor.getAnnotation(Inject.class) != null){
                try {
                    Constructor<T> tConstructor = cls.getConstructor(ctor.getParameterTypes());
                    return tConstructor.newInstance(dependencies);
                } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
                    throw new ClassBuildException("Instance couldn't create",e);
                }
            }
        }
        throw new ClassBuildException(String.format("Instance couldn't created. Couldn't find a constructor that annotated with %s",Inject.class.getName()));
    }

    @Override
    public <T> T build(Class<T> cls) {
        return build(cls,null);
    }
}
