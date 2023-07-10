package org.example.clinique.animals.types;

import org.example.clinique.animals.Animal;
import org.example.clinique.animals.interfaces.Swimable;
import org.example.clinique.humans.clients.Owner;

public class Fish extends Animal implements Swimable {
    public Fish(String name, Integer age, String vaccination, String color, String species, Owner owner, Integer legsCount) {
        super(name, age, vaccination, color, species, owner, legsCount);
    }

    public Fish(String name, String species, Owner owner) {
        super(name, species, owner);
    }

    public Fish(String name, String species) {
        super(name, species);
    }
}
