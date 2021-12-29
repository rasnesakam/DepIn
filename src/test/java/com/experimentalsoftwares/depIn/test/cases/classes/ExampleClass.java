package com.experimentalsoftwares.depIn.test.cases.classes;

import com.experimentalsoftwares.depInJava.utils.annotations.Dependent;
import com.experimentalsoftwares.depInJava.utils.annotations.Inject;

public class ExampleClass {

    private String dependency;

    private String secretString;

    public String publicDependency;


    public ExampleClass(String dependency){
        System.out.println("Injected");
        this.dependency = dependency;
    }

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
