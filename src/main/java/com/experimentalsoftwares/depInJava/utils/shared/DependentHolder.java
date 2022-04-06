package com.experimentalsoftwares.depInJava.utils.shared;

import java.util.List;
import java.util.Map;

public class DependentHolder {
    private Class<?> cls;
    private Object predefined;
    private String label;

    public Class<?> getCls() {
        return cls;
    }

    public void setCls(Class<?> cls) {
        this.cls = cls;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Object getPredefined() {
        return predefined;
    }

    public void setPredefined(Object predefined) {
        this.predefined = predefined;
    }
}
