package com.experimentalsoftwares.depIn.test.cases.classes;

public class ExampleClass {

    private final String  dependency;

    private String secretString;

    public String publicDependency;

    public ExampleClass(){
        this.dependency = "undefined";
    }

    public ExampleClass(String dependency){
        this.dependency = dependency;
    }

    public void setSecretString(String secretString) {
        this.secretString = secretString;
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
