package org.example;

public class Fish extends Animal{
    public Fish(String name, Integer age, String vaccination, String color, String species, Owner owner, Integer legsCount) {
        super(name, age, vaccination, color, species, owner, legsCount);
    }

    public Fish(String name, String species, Owner owner) {
        super(name, species, owner);
    }

    public Fish(String name, String species) {
        super(name, species);
    }

    @Override
    public void fly(float speed, float time, float height, String direction) {
        System.out.printf("%s %s is unable to fly.\n", this.species, this.name);
    }
    @Override
    public void go(float speed, float time, String direction) {
        System.out.printf("%s %s cannot walk.\n", this.species, this.name);
    }
}
