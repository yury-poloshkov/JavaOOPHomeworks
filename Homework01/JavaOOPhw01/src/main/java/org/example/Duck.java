package org.example;

public class Duck extends Animal{

    public Duck(String name, Integer age, String vaccination, String color, String species, Owner owner, Integer legsCount) {
        super(name, age, vaccination, color, species, owner, legsCount);
    }
    public Duck(String name, String species, Owner owner) {
        super(name, species, owner);
    }
    public Duck(String name, String species) {
        super(name, species);
    }
}
