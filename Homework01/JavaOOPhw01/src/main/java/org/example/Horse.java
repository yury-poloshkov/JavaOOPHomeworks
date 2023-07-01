package org.example;

public class Horse extends Animal{

    public Horse(String name, Integer age, String vaccination, String color, String species, Owner owner, Integer legsCount) {
        super(name, age, vaccination, color, species, owner, legsCount);
    }

    public Horse(String name, String species, Owner owner) {
        super(name, species, owner);
    }

    public Horse(String name, String species) {
        super(name, species);
    }
    @Override
    public void fly(float speed, float time, float height, String direction) {
        System.out.printf("%s %s is not Pegasus. It is unable to fly.\n", this.species, this.name);
    }
    @Override
    public void swim(float speed, float time, float depth, String direction) {
        System.out.printf("%s %s is not seahorse. It is unable to swim.\n", this.species, this.name);
    }
}
