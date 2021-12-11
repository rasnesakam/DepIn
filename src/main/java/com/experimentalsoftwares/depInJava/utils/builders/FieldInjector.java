package com.experimentalsoftwares.depInJava.utils.builders;

import java.lang.reflect.Field;
import java.util.Map;

/**
 * @author Ensar Makas
 *
 * <h3>FieldInjector</h3>
 * <p>Injects the fields of the given object</p>
 */
public class FieldInjector extends Injector {

    @Override
    public boolean inject(){
        // TODO inject

        Class cls = instance.getClass();

        map.forEach((key,obj)->{
            try {
                Field f = cls.getDeclaredField(key);
                boolean isPrivate = !f.canAccess(instance);
                if (f.trySetAccessible()){
                    f.set(instance,obj);
                }
                if (isPrivate) f.setAccessible(false);
            } catch (NoSuchFieldException | IllegalAccessException e) {
                e.printStackTrace();
            }
        });
        return false;
    }
}
