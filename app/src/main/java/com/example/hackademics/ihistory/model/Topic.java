package com.example.hackademics.ihistory.model;

/**
 * Created by Nhan on 02/08/2015.
 */
public class Topic {
    private String name;
    private String value;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Topic(String name, String value) {
        this.name = name;
        this.value = value;
    }
}
