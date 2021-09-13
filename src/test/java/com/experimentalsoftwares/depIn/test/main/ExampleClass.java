package com.experimentalsoftwares.depIn.test.main;

import com.experimentalsoftwares.depInJava.utils.annotations.Dependent;
import com.experimentalsoftwares.depInJava.utils.annotations.Inject;

public class ExampleClass {

    @Dependent
    private String dependency;

    @Inject
    public ExampleClass(String dependency){
        System.out.println("Injected");
        this.dependency = dependency;
    }

    public ExampleClass(){}

    public String getDependency() {
        return dependency;
    }
}
