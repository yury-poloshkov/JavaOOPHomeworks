package org.example.clinique.humans;

import java.util.Date;
import java.util.HashMap;

public class Human {
    protected final String name;
    protected Date birthDate;
    protected HashMap<String, Long> phoneNumbers;

    public Human(String name, Date birthDate, HashMap<String, Long> phoneNumbers) {
        this.name = name;
        this.birthDate = birthDate;
        this.phoneNumbers = phoneNumbers;
    }
    public Human(String name){
        this.name = name;
        this.birthDate = null;
        this.phoneNumbers = null;

    }
    public void addPhone(String phoneType, Long phoneNumber){
        phoneNumbers.put(phoneType, phoneNumber);
    }
    @Override
    public String toString() {
        return name;
    }
}
