package org.example.clinique.humans.staff;

import org.example.clinique.humans.Human;


import java.sql.Date;
import java.util.HashMap;

public class Employee extends Human {
    int id;
    private Date hireDate;
    private float salary;
    private Date fireDate;

    String position;

    public Employee(int id, String name, Date birthDate, HashMap<String, Long> phoneNumbers,
                    Date hireDate, String position, float salary){
        super(name, birthDate, phoneNumbers);
        this.id = id;
        this.hireDate = hireDate;
        this.position = position;
        this.salary = salary;
        this.fireDate = null;
    }
    public Employee(int id,  String name, Date birthDate, HashMap<String, Long> phoneNumbers,
                    Date hireDate, String position) {
        super(name, birthDate, phoneNumbers);
        this.id = id;
        this.hireDate = hireDate;
        this.position = position;
    }
    public Employee(int id, String name, String position, Date hireDate) {
        super(name);
        this.id = id;
        this.hireDate = hireDate;
        this.position = position;
    }
    public void setSalary(float salary){
        this.salary = salary;
    }
    public void setPosition(String position){
        this.position = position;
    }
    public void fire(Date fireDate){
        this.fireDate = fireDate;
    }

    @Override
    public String toString() {
        return "Employee{" +
                position + " " + super.toString() +
                ", id=" + id +
                ", hireDate=" + hireDate +
                ", salary=" + salary +
                '}';
    }
}
