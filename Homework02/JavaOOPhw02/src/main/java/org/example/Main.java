package org.example;

import org.example.animals.*;
import org.example.animals.interfaces.Soundable;
import org.example.clients.Owner;
import org.example.clinique.VetClinique;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        List <Animal> animals = new ArrayList<>();
        Animal duck = new Duck("Donald","Duck", new Owner("Scrudge"));
        animals.add(duck);
        Animal fish = new Fish("Nemo", "Fish", new Owner("Ariel"));
        animals.add(fish);
        Animal horse = new Horse("Bolivar", "Mustang", new Owner("Morris"));
        animals.add(horse);
        Animal ostrich = new Ostrich("Chunk", "Ostrich", new Owner("Papuas"));
        animals.add(ostrich);
        Animal parrot = new Parrot("Silver", "Parrot", new Owner("Flint"));
        animals.add(parrot);
        Animal turtle = new Turtle("Donatello", "Turtle", new Owner("Splinter"));
        animals.add(turtle);
        Random rnd = new Random();

        for (Animal item : animals) {
            if (item instanceof Soundable){
                System.out.print(item.toString() + " ");
                ((Soundable) item).sound(rnd.nextFloat(10), rnd.nextFloat(10));
            }
        }
        // List<Animal> soundableAnimals = new VetClinique();
    }
}
