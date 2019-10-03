package org.healthtest.model;

import org.springframework.beans.factory.*;

public class Dog implements BeanNameAware {
    private String name;
    private String description;

    public Dog() {
    }

    public Dog(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public void setBeanName(String name) {

    }
}
