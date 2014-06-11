package com.manpower.restdoc.model;

/**
 * Created by sbert on 11/06/2014.
 */
public class Person {

    String name;
    String race;

    public Person(String name, String race) {
        this.name = name;
        this.race = race;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }
}
