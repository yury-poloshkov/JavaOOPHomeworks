package org.example.clinique;

import org.example.animals.Animal;
import org.example.animals.interfaces.Flyable;
import org.example.animals.interfaces.Runable;
import org.example.animals.interfaces.Soundable;
import org.example.animals.interfaces.Swimable;

import java.util.ArrayList;
import java.util.List;

public class VetClinique {
    public List selectSwimable(List<Animal> animals){
        List<Animal> selectedAnimals = new ArrayList<>();
        for (Animal animal: animals) {
            if (animal instanceof Swimable){
                selectedAnimals.add(animal);
            }
        }
        return selectedAnimals;
    }
    public List selectSoundable(List<Animal> animals){
        List<Animal> selectedAnimals = new ArrayList<>();
        for (Animal animal: animals) {
            if (animal instanceof Soundable){
                selectedAnimals.add(animal);
            }
        }
        return selectedAnimals;
    }
    public List selectFlyable(List<Animal> animals){
        List<Animal> selectedAnimals = new ArrayList<>();
        for (Animal animal: animals) {
            if (animal instanceof Flyable){
                selectedAnimals.add(animal);
            }
        }
        return selectedAnimals;
    }
    public List selectRunnable(List<Animal> animals){
        List<Animal> selectedAnimals = new ArrayList<>();
        for (Animal animal: animals) {
            if (animal instanceof Runable){
                selectedAnimals.add(animal);
            }
        }
        return selectedAnimals;
    }
}
