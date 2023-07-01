package org.example;

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

    public void go(float speed, float time, String direction){
        System.out.printf("%s %s went %s for %.2f km in %.2f hours.\n",
                this.species, this.name, direction, speed * time, time);
    }
    public void fly(float speed, float time, float height, String direction){
        System.out.printf("%s %s flied %s for %.2f km in %.2f hours at %.2f m height.\n",
                this.species, this.name, direction, speed * time, time, height);
    }
    public void swim(float speed, float time, float depth, String direction){
        System.out.printf("%s %s swam %s for %.2f km in %.2f hours at %.2f m depth.\n",
                this.species, this.name, direction, speed * time, time, depth);
    }
    public Integer getAge() {
        return age;
    }
    public void setAge(Integer age) {
        this.age = age;
    }
    @Override
    public String toString() {
        return String.format("Animal: {name = %s, owner = %s}", name, owner);
    }
}