package org.example.clinique.animals.types;

import org.example.clinique.animals.Animal;
import org.example.clinique.animals.interfaces.Flyable;
import org.example.clinique.animals.interfaces.Runable;
import org.example.clinique.animals.interfaces.Soundable;
import org.example.clinique.animals.interfaces.Swimable;
import org.example.clinique.humans.clients.Owner;

public class Duck extends Animal implements Runable, Swimable, Flyable, Soundable {

    public Duck(String name, Integer age, String vaccination, String color, String species, Owner owner, Integer legsCount) {
        super(name, age, vaccination, color, species, owner, legsCount);
    }
    public Duck(String name, String species, Owner owner) {
        super(name, species, owner);
    }
    public Duck(String name, String species) {
        super(name, species);
    }
}
