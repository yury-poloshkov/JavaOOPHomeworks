package org.example.animals;

import org.example.animals.interfaces.Flyable;
import org.example.animals.interfaces.Runable;
import org.example.animals.interfaces.Soundable;
import org.example.animals.interfaces.Swimable;
import org.example.clients.Owner;

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
