package com.experimentalsoftwares.depInJava.utils.classAnalyzer.concretes;

import com.experimentalsoftwares.depInJava.utils.classAnalyzer.abstracts.ClassAnalyzer;
import com.experimentalsoftwares.depInJava.utils.annotations.Dependent;

import java.lang.reflect.Field;
import java.util.ArrayList;

/**
 *
 * <h1>FieldAnalyzer</h1>
 * <p>
 *     Analyzes dependencies of the class by looking to {@link Dependent annotated} fields
 * </p>
 * @author Ensar Makas
 * @since 22.08.2021
 * @version 1.0
 * @see ClassAnalyzer
 * @see Dependent
 */

public class FieldAnalyzer implements ClassAnalyzer {
    @Override
    public Class[] getDependencies(Class cls) {
        ArrayList<Class> paramTypes = new ArrayList<>();
        for (Field field : cls.getFields()){
            if(field.getDeclaredAnnotation(Dependent.class) != null) paramTypes.add(field.getType());
        }
        return paramTypes.toArray(Class[]::new);
    }
}
