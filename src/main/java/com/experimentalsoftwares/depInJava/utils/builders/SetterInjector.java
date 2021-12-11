package com.experimentalsoftwares.depInJava.utils.builders;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

public class SetterInjector extends Injector {

    @Override
    public boolean inject(){
        // TODO inject setters
        Class cls = instance.getClass();

        map.forEach((key,val)->{
            try {
                Method method = cls.getDeclaredMethod(key,val.getClass());
                method.invoke(instance,val);
            } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        });
        return false;
    }

}
