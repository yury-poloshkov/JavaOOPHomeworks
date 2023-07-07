package org.example.animals;

import org.example.animals.interfaces.Flyable;
import org.example.animals.interfaces.Soundable;
import org.example.clients.Owner;

public class Parrot extends Animal implements Flyable, Soundable {

    public Parrot(String name, Integer age, String vaccination, String color, String species, Owner owner, Integer legsCount) {
        super(name, age, vaccination, color, species, owner, legsCount);
    }

    public Parrot(String name, String species, Owner owner) {
        super(name, species, owner);
    }

    public Parrot(String name, String species) {
        super(name, species);
    }
}
