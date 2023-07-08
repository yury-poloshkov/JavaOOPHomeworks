package org.example.clinique.animals;

import org.example.clinique.humans.clients.Owner;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Animal {
    protected String name;
    protected Integer age;
    protected String vaccination;
    protected String color;
    protected String species;
    protected Owner owner;
    protected Integer legsCount;

    protected List<String> medicalCard;

    //---Constructors---
    public Animal(String name, Integer age, String vaccination, String color,
            String species, Owner owner, Integer legsCount) {
        this.name = name;
        this.age = age;
        this.vaccination = vaccination;
        this.color = color;
        this.species = species;
        this.owner = owner;
        this.legsCount = legsCount;
        this.medicalCard = new ArrayList<>();
    }
    public Animal(String color, String species, Integer legsCount) {
        this("Unnamed", null, null, color, species, null, legsCount);
    }
    public Animal (String name, String species, Owner owner){
        this(name, null, null, null, species, owner, null);
    }
    public Animal (String name, String species){
        this(name, species, (Owner) null);
    }

    public void setVaccination(String vaccine){
        this.vaccination = vaccine;
    }
    public void addRecordToMedicalCard (String record){
        this.medicalCard.add(record);
    }
    public void getMedicalRecords(){
        System.out.printf("--- Medical Card for %s ---\n", this.toString());
        for (String record: medicalCard) {
            System.out.println(record);
        }
    }
    public Integer getAge() {
        return age;
    }
    public void setAge(Integer age) {
        this.age = age;
    }
    @Override
    public String toString() {
        return String.format("Animal: {%s %s, owner = %s}", species, name, owner);
    }
}