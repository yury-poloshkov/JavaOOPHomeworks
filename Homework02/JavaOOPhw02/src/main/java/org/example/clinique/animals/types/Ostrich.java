package org.example.clinique.animals.types;

import org.example.clinique.animals.Animal;
import org.example.clinique.animals.interfaces.Runable;
import org.example.clinique.animals.interfaces.Soundable;
import org.example.clinique.humans.clients.Owner;

public class Ostrich extends Animal implements Runable, Soundable {

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
}
