package com.cyliu.tinyioc;

public class BeanReference {
    private String name;
    private String ref;

    public BeanReference(String ref) {
        this.ref = ref;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }
}
