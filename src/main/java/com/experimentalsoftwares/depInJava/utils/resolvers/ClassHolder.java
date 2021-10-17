package com.experimentalsoftwares.depInJava.utils.resolvers;

public class ClassHolder {
    private Class target;
    private ClassHolder dependencies;

    public ClassHolder(Class target, ClassHolder dependencies) {
        this.target = target;
        this.dependencies = dependencies;
    }

    public ClassHolder(Class target) {
        this.target = target;
    }

    public Class getTarget() {
        return target;
    }

    public ClassHolder getDependencies() {
        return dependencies;
    }
}
