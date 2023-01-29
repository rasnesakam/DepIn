package com.emakas.depIn.utils.shared;

public class DependentHolder {

    /**
     * Class name of the dependent
     */
    private Class<?> cls;

    /**
     * <p>Predefined instance of the dependency</p>
     * <p></p>
     */
    private Object instance;

    /**
     *
     */
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

    public Object getInstance() {
        return instance;
    }

    public void setInstance(Object instance) {
        this.instance = instance;
    }
}
