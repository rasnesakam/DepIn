package com.emakas.depIn.utils.builders;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class SetterInjector extends Injector {

    @Override
    public void inject(){
        Class<?> cls = instance.getClass();

        map.forEach((key,val)->{
            try {
                Method method = cls.getDeclaredMethod(key,val.getClass());
                method.invoke(instance,val);
            } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        });
    }

}
