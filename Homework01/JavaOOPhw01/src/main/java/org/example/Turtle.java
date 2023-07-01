package org.example;

public class Turtle extends Animal{

    public Turtle(String name, Integer age, String vaccination, String color, String species, Owner owner, Integer legsCount) {
        super(name, age, vaccination, color, species, owner, legsCount);
    }

    public Turtle(String name, String species, Owner owner) {
        super(name, species, owner);
    }

    public Turtle(String name, String species) {
        super(name, species);
    }
    @Override
    public void swim(float speed, float time, float depth, String direction) {
        System.out.printf("%s %s: Sorry, born to crawl cannot fly.\n", this.species, this.name);
    }
}
