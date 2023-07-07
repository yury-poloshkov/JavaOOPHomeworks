package org.example.animals;

import org.example.clients.Owner;

public class Animal {
    protected String name;
    protected Integer age;
    protected String vaccination;
    protected String color;
    protected String species;
    protected Owner owner;
    protected Integer legsCount;

    //---Constructors---
    public Animal(String name, Integer age, String vaccination, String color,
            String species, Owner owner, Integer legsCount) {
        this.name = name;
        this.age = age;
        this.vaccination = vaccination;
        this.color = color;
        this.species = species;
        this.owner = owner;
        this.legsCount = legsCount;
    }
    public Animal(String color, String species, Integer legsCount) {
        this("Unnamed", null, null, color, species, null, legsCount);
    }
    public Animal (String name, String species, Owner owner){
        this(name, null, null, null, species, owner, null);
    }
    public Animal (String name, String species){
        this(name, species, (Owner) null);
    }

    public Integer getAge() {
        return age;
    }
    public void setAge(Integer age) {
        this.age = age;
    }
    @Override
    public String toString() {
        return String.format("Animal: {%s %s, owner = %s}", species, name, owner);
    }
}