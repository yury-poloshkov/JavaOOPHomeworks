package org.example.clinique.humans.staff;

import org.example.clinique.animals.Animal;

import java.sql.Date;

public class Therapist extends Doctor{
    public Therapist(int id, String name, String position, Date hireDate) {
        super(id, name, position, hireDate);
    }
    public void vaccinateAnimal(Animal animal, Date date, String vaccine) {
        animal.addRecordToMedicalCard(this.position + " " + this.name + "; " +
                date.toString() + "; vaccination; " + vaccine);
        animal.setVaccination(vaccine + " " + date.toString());
    }
}
