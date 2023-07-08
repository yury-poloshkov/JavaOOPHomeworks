package org.example.clinique;

import org.example.clinique.animals.Animal;
import org.example.clinique.animals.interfaces.Flyable;
import org.example.clinique.animals.interfaces.Runable;
import org.example.clinique.animals.interfaces.Soundable;
import org.example.clinique.animals.interfaces.Swimable;

import java.util.ArrayList;
import java.util.List;

public class VetClinique {

    public List<Animal> selectSwimable(List<Animal> animals){
        List<Animal> selectedAnimals = new ArrayList<>();
        for (Animal animal: animals) {
            if (animal instanceof Swimable){
                selectedAnimals.add(animal);
            }
        }
        return selectedAnimals;
    }
    public List<Animal> selectSoundable(List<Animal> animals){
        List<Animal> selectedAnimals = new ArrayList<>();
        for (Animal animal: animals) {
            if (animal instanceof Soundable){
                selectedAnimals.add(animal);
            }
        }
        return selectedAnimals;
    }
    public List<Animal> selectFlyable(List<Animal> animals){
        List<Animal> selectedAnimals = new ArrayList<>();
        for (Animal animal: animals) {
            if (animal instanceof Flyable){
                selectedAnimals.add(animal);
            }
        }
        return selectedAnimals;
    }
    public List<Animal> selectRunable(List<Animal> animals){
        List<Animal> selectedAnimals = new ArrayList<>();
        for (Animal animal: animals) {
            if (animal instanceof Runable){
                selectedAnimals.add(animal);
            }
        }
        return selectedAnimals;
    }
}
