package com.experimentalsoftwares.depIn.test.main;

import com.experimentalsoftwares.depInJava.utils.annotations.Dependent;
import com.experimentalsoftwares.depInJava.utils.annotations.Inject;

public class ExampleClass {

    @Dependent
    private String dependency;

    @Dependent
    private String secretString;


    public ExampleClass(String dependency){
        System.out.println("Injected");
        this.dependency = dependency;
    }

    @Inject
    public ExampleClass(){}

    public void setDependency(String dependency) {
        this.dependency = dependency;
    }
    public String getDependency() {
        return dependency;
    }


    public String getSecretString() {
        return secretString;
    }

    @Override
    public String toString() {
        return "ExampleClass{" +
                "dependency='" + dependency + '\'' +
                ", secretString='" + secretString + '\'' +
                '}';
    }
}
