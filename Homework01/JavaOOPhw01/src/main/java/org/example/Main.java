package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Animal animal = new Animal("Slon", 32, "true", "White",
        "Mammal", new Owner("Stas"), 4);
        Animal animal1 = new Animal("Black", "Bird", 2);
        List <Animal> animals = new ArrayList<>();
        animals.add(new Dog(null, "Dog", null));
        animals.add(new Cat(null, "Cat", null));
        animals.add(animal);
        animals.add(animal1);
        Random rnd = new Random(100);
        for (Animal item : animals) {
            item.go(rnd.nextFloat(), rnd.nextFloat(), "south");
            item.fly(rnd.nextFloat(), rnd.nextFloat(), rnd.nextFloat(),"south");
            item.swim(rnd.nextFloat(), rnd.nextFloat(), rnd.nextFloat(),"south");
        }
    }
}
