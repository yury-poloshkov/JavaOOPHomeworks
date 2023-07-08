package org.example;

import org.example.clinique.animals.*;
import org.example.clinique.animals.types.*;
import org.example.clinique.humans.clients.Owner;
import org.example.clinique.VetClinique;
import org.example.clinique.humans.staff.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // создаем тестовый набор пациентов-животных
        List <Animal> animals = new ArrayList<>();
        generateTestAnimals(animals);

        // Подзадача №4: фильтруем животных по типам интерфейсов и выводим списки
        VetClinique testClinique = new VetClinique();

        List<Animal> flyableAnimals = testClinique.selectFlyable(animals);
        System.out.println("Flyable animals: " + flyableAnimals.toString());

        List<Animal> runableAnimals = testClinique.selectRunable(animals);
        System.out.println("Runable animals: " + runableAnimals.toString());

        List<Animal> swimableAnimals = testClinique.selectSwimable(animals);
        System.out.println("Swimable animals: " + swimableAnimals.toString());

        List<Animal> soundableAnimals = testClinique.selectSoundable(animals);
        System.out.println("Soundable animals: " + soundableAnimals.toString() + "\n");

        // Подзадача №3: содаем тестовый состав клиники и проводим тестовый прием
        List<Employee> cliniqueStuff = new ArrayList<>();
        generateTestStuff(cliniqueStuff);
        System.out.println(cliniqueStuff + "\n");

        ((Nurse) cliniqueStuff.get(1)).cleanRoom("Смотровая");
        ((Nurse) cliniqueStuff.get(1)).washAnimal(animals.get(0), new Date(123,7,9));
        ((Nurse) cliniqueStuff.get(1)).groomAnimal(animals.get(0), new Date(123,7,9), "wings");
        ((Therapist) cliniqueStuff.get(2)).surveyAnimal(animals.get(0), new Date(123,7,9),
                "primary survey", "Тяжелая форма птичьего гриппа");
        ((Therapist) cliniqueStuff.get(2)).appointTreatment(animals.get(0), new Date(123,7,9),
                "СРОЧНО: вакцина от птичьего гриппа, удалить клюв!!!");
        ((Therapist) cliniqueStuff.get(2)). vaccinateAnimal(animals.get(0), new Date(123,7,9),
                "вакцина от птичьего гриппа");
        ((Surgeon) cliniqueStuff.get(0)).operateAnimal(animals.get(0), new Date(123,7,9),
                "cutting", "клюв");
        ((Surgeon) cliniqueStuff.get(0)).surveyAnimal(animals.get(0), new Date(123,7,9),
                "testing for surviveability", "Плохо дело :(");
        ((Surgeon) cliniqueStuff.get(0)).euthanizeAnimal(animals.get(0), new Date(123,7,9));
        ((Nurse) cliniqueStuff.get(1)).cleanRoom("Смотровая");

        animals.get(0).getMedicalRecords();
    }

    private static void generateTestStuff(List<Employee> cliniqueStuff) {
        Doctor doctor = new Surgeon(1, "Petrov", "Surgeon",new Date(120,10,2));
        cliniqueStuff.add(doctor);
        Nurse nurse = new Nurse(2, "Annette", "Nurse", new Date(120,2,5));
        cliniqueStuff.add(nurse);
        Doctor doctor1 = new Therapist(3, "Ihaveapain", "Therapist",new Date(121,10,20));
        cliniqueStuff.add(doctor1);
    }

    private static void generateTestAnimals(List<Animal> animals){
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
    }
}
