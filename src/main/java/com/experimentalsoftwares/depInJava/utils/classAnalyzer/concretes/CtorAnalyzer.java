package com.experimentalsoftwares.depInJava.utils.classAnalyzer.concretes;

import com.experimentalsoftwares.depInJava.utils.annotations.Inject;
import com.experimentalsoftwares.depInJava.utils.classAnalyzer.abstracts.ClassAnalyzer;

import java.lang.reflect.Constructor;

public class CtorAnalyzer implements ClassAnalyzer {
    @Override
    public Class[] getDependencies(Class cls) {
        Class[] paramTypes = new Class[0];
        for (Constructor ctor : cls.getConstructors()){
            if (ctor.getDeclaredAnnotation(Inject.class) != null){
                paramTypes = new Class[ctor.getParameterTypes().length];
                for (int i = 0; i < paramTypes.length; i++) paramTypes[i] = ctor.getParameters()[i].getType();
            }
        }
        return paramTypes;
    }
}
