package org.example.animals;

import org.example.animals.interfaces.Runable;
import org.example.animals.interfaces.Swimable;
import org.example.clients.Owner;

public class Turtle extends Animal implements Runable, Swimable {

    public Turtle(String name, Integer age, String vaccination, String color, String species, Owner owner, Integer legsCount) {
        super(name, age, vaccination, color, species, owner, legsCount);
    }

    public Turtle(String name, String species, Owner owner) {
        super(name, species, owner);
    }

    public Turtle(String name, String species) {
        super(name, species);
    }
}
