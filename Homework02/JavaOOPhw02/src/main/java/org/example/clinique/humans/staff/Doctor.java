package org.example.clinique.humans.staff;


import org.example.clinique.animals.Animal;

import java.sql.Date;
import java.util.HashMap;

public class Doctor extends Employee{

    public Doctor(int id, String name, Date birthDate, HashMap<String, Long> phoneNumbers, Date hireDate, String position, float salary) {
        super(id, name, birthDate, phoneNumbers, hireDate, position, salary);
    }

    public Doctor(int id, String name, String position, java.sql.Date hireDate) {
        super(id, name, position, hireDate);
    }
    public void surveyAnimal(Animal animal, Date date, String surveyType, String result){
        animal.addRecordToMedicalCard(this.position + " " + this.name + "; " +
                date.toString() +"; " +  surveyType + "; " + result);
    }
    public void  appointTreatment(Animal animal, Date date, String appointment){
        animal.addRecordToMedicalCard(this.position + " " + this.name + "; " +
                date.toString() +"; appointment; " + appointment);
    }
}

