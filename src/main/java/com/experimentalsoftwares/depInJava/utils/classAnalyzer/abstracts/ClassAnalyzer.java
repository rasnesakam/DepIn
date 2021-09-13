package com.experimentalsoftwares.depInJava.utils.classAnalyzer.abstracts;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public interface ClassAnalyzer {
    Class[] getDependencies(Class cls);
}
