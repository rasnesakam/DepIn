package com.experimentalsoftwares.depInJava.utils.resolvers;

import com.experimentalsoftwares.depInJava.utils.builders.abstracts.InstanceBuilder;

import java.util.ArrayList;

public class ClassBundle {
    private Class targetClass;
    private ArrayList<ClassBundle> dependencies;
    private Class<? extends InstanceBuilder> builderClass;

    public ClassBundle() {
        dependencies = new ArrayList<>();
    }

    public Class getTargetClass() {
        return targetClass;
    }

    public void setTargetClass(Class targetClass) {
        this.targetClass = targetClass;
    }

    public Class<? extends InstanceBuilder> getBuilderClass() {
        return builderClass;
    }

    public void setBuilderClass(Class<? extends InstanceBuilder> builderClass) {
        this.builderClass = builderClass;
    }

    public ArrayList<ClassBundle> getDependencies() {
        return dependencies;
    }

    public void putDependency(ClassBundle bundle){
        dependencies.add(bundle);
    }
}
