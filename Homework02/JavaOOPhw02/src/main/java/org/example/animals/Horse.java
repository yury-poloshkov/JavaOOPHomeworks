package org.example.animals;

import org.example.animals.interfaces.Runable;
import org.example.animals.interfaces.Soundable;
import org.example.clients.Owner;

public class Horse extends Animal implements Runable, Soundable {

    public Horse(String name, Integer age, String vaccination, String color, String species, Owner owner, Integer legsCount) {
        super(name, age, vaccination, color, species, owner, legsCount);
    }

    public Horse(String name, String species, Owner owner) {
        super(name, species, owner);
    }

    public Horse(String name, String species) {
        super(name, species);
    }
}
