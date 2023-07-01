package org.example;

public class Ostrich extends Animal{

    public Ostrich(String name, Integer age, String vaccination, String color, String species, Owner owner, Integer legsCount) {
        super(name, age, vaccination, color, species, owner, legsCount);
    }

    public Ostrich(String name, String species, Owner owner) {
        super(name, species, owner);
    }

    public Ostrich(String name, String species) {
        super(name, species);
    }
    private void hideHead(){
        System.out.printf("Bang... %s hides head in sand! ",this.species);
    }
    @Override
    public void fly(float speed, float time, float height, String direction) {
        hideHead();
        System.out.printf("%s %s is unable to fly.\n", this.species, this.name);
    }
    @Override
    public void swim(float speed, float time, float depth, String direction) {
        hideHead();
        System.out.printf("%s %s is unable to swim.\n", this.species, this.name);
    }
}
