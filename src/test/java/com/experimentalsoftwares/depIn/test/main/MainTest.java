package com.experimentalsoftwares.depIn.test.main;

import com.experimentalsoftwares.depInJava.core.BasicInstanceFactory;
import com.experimentalsoftwares.depInJava.utils.classBuilders.concretes.CTorInjector;
import com.experimentalsoftwares.depInJava.utils.classBuilders.concretes.FieldInjector;
import com.experimentalsoftwares.depInJava.utils.exceptions.ClassBuildException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class MainTest {

    @Test
    public void test1() {
        BasicInstanceFactory factory = new BasicInstanceFactory();
        try {
            ExampleClass exampleClass = factory.generateInstance(ExampleClass.class.getName());
        } catch (ClassBuildException e) {
            e.printStackTrace();
        }
    }
}
