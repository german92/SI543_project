package com.example.troy.linguameethome;

/**
 * Created by Troy on 11/25/2014.
 */
public class Person {
    private String name;
    private String description;


    public Person(String name, String description) {

        this.name = name;
        this.description = description;

    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}