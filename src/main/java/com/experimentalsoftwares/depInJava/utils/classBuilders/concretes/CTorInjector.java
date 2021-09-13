package com.experimentalsoftwares.depInJava.utils.classBuilders.concretes;

import com.experimentalsoftwares.depInJava.utils.annotations.Inject;
import com.experimentalsoftwares.depInJava.utils.classBuilders.abstracts.ClassBuilder;
import com.experimentalsoftwares.depInJava.utils.exceptions.ClassBuildException;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Parameter;
import java.util.function.Supplier;

public class CTorInjector implements ClassBuilder {
    @Override
    public <T> T build(Class<T> cls) throws ClassBuildException {

        return build(cls,() -> null);
    }

    @Override
    public <T> T build(Class<T> cls, Supplier<Object[]> deps) throws ClassBuildException {

        Constructor[] ctors = cls.getConstructors();

        for(Constructor ctor : ctors){
            if(ctor.getDeclaredAnnotation(Inject.class) != null){
                try {
                    for(Parameter p : ctor.getParameters()) System.out.println(p.getName());
                    return (T) ctor.newInstance(deps.get());
                } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
                    throw new ClassBuildException("The instance of this class couldn't created. See the exceptions:\n",e);
                }
            }
        }

        return null;
    }
}
