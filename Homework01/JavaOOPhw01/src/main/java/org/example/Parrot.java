package org.example;

public class Parrot extends Animal{

    public Parrot(String name, Integer age, String vaccination, String color, String species, Owner owner, Integer legsCount) {
        super(name, age, vaccination, color, species, owner, legsCount);
    }

    public Parrot(String name, String species, Owner owner) {
        super(name, species, owner);
    }

    public Parrot(String name, String species) {
        super(name, species);
    }
    @Override
    public void go(float speed, float time, String direction) {
        System.out.printf("%s %s is too lazy to go. Why should you walk if you have wings!.\n", this.species, this.name);
    }
    @Override
    public void swim(float speed, float time, float depth, String direction) {
        System.out.printf("%s %s is unable to swim.\n", this.species, this.name);
    }
}
