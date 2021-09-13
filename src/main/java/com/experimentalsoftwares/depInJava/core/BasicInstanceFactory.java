package com.experimentalsoftwares.depInJava.core;

import com.experimentalsoftwares.depInJava.utils.annotations.Inject;
import com.experimentalsoftwares.depInJava.utils.classAnalyzer.abstracts.ClassAnalyzer;
import com.experimentalsoftwares.depInJava.utils.classAnalyzer.concretes.CtorAnalyzer;
import com.experimentalsoftwares.depInJava.utils.classBuilders.abstracts.ClassBuilder;
import com.experimentalsoftwares.depInJava.utils.classBuilders.concretes.CTorInjector;
import com.experimentalsoftwares.depInJava.utils.exceptions.ClassBuildException;

import java.lang.reflect.Constructor;

public class BasicInstanceFactory {

    public <T> T generateInstance(String name) throws ClassBuildException {
        ClassAnalyzer analyzer;
        ClassBuilder builder;
        Class<T> cls = null;
        try {
            cls = (Class<T>) Class.forName(name);
        } catch (ClassNotFoundException e) {
            throw new ClassBuildException("Class couldn't found",e);
        } catch (ClassCastException e){
            throw new ClassBuildException("Given class has no relation with provided class",e);
        }
        T instance = null;

        if(hasConstroctor(cls)){
            analyzer = new CtorAnalyzer();
            builder = new CTorInjector();
            Class[] classes = analyzer.getDependencies(cls);
            for(Class c : classes) generateInstance(cls.getName());
            instance = builder.build(cls,()->classes);
        }


        return instance;
    }
    private boolean hasConstroctor(Class cls){
        for(Constructor ctor : cls.getDeclaredConstructors())
            if(ctor.getDeclaredAnnotation(Inject.class) != null) return true;
        return false;
    }

}
