package org.example.clinique.humans.staff;

import org.example.clinique.animals.Animal;

import java.sql.Date;

public class Surgeon extends Doctor{
    public Surgeon(int id, String name, String position, Date hireDate) {
        super(id, name, position, hireDate);
    }
    public void operateAnimal(Animal animal, Date date, String operation, String organ){
        animal.addRecordToMedicalCard(this.position + " " + this.name + "; " +
                date.toString() +"; " +  operation + "; " + organ);
    }
    public void euthanizeAnimal(Animal animal, Date date){
        animal.addRecordToMedicalCard(this.position + " " + this.name + "; " +
                date.toString() +"; euthanasia; R.I.P.");
    }

}
