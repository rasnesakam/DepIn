package com.emakas.depIn.utils.builders;

import java.lang.reflect.Field;

/**
 * @author Ensar Makas
 *
 * <h3>FieldInjector</h3>
 * <p>Injects the fields of the given object</p>
 */
public class FieldInjector extends Injector {

    @Override
    public void inject(){

        Class<?> cls = instance.getClass();

        map.forEach((key,obj)->{
            try {
                Field f = cls.getDeclaredField(key);
                if (f.trySetAccessible()){
                    f.set(instance,obj);
                }
            } catch (NoSuchFieldException | IllegalAccessException e) {
                e.printStackTrace();
            }
        });
    }
}
