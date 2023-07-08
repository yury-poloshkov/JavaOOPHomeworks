package org.example.clinique.humans.staff;

import org.example.clinique.animals.Animal;

import java.sql.Date;
import java.util.HashMap;

public class Nurse extends Employee{
    public Nurse(int id, String name, Date birthDate, HashMap<String, Long> phoneNumbers, Date hireDate, String position, float salary) {
        super(id, name, birthDate, phoneNumbers, hireDate, position, salary);
    }

    public Nurse(int id, String name, String position, Date hireDate) {
        super(id, name, position, hireDate);
    }

    public void cleanRoom(String room){
        System.out.println(this.position + " " + this.name + " cleaned room: " + room);
    }
    public void washAnimal(Animal animal, Date date){
        animal.addRecordToMedicalCard(this.position + " " + this.name + "; " +
                date.toString() +"; washing; successful");
    }
    public void groomAnimal(Animal animal, Date date, String organ){
        animal.addRecordToMedicalCard(this.position + " " + this.name + "; " +
                date.toString() +"; grooming; " + organ);
    }
}
