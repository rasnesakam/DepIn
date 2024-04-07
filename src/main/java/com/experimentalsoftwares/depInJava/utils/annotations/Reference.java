package com.experimentalsoftwares.depInJava.utils.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface Reference {
    Class<?> reference() default Object.class;
}
