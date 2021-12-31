package com.experimentalsoftwares.depIn.test.cases.classes;

public class ExampleClass {

    private final String  dependency;

    private String secretString;

    public String publicDependency;

    public ExampleClass(String dependency){
        System.out.println("Injected");
        System.out.println(dependency);
        this.dependency = dependency;
    }

    public void setDependency(String dependency) {
        System.out.println("Setter injected");
        //this.dependency = dependency;
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
