package org.example.clinique.humans.clients;

import org.example.clinique.humans.Human;

import java.util.Date;
import java.util.HashMap;

public class Owner extends Human {
    public Owner(String name, Date birthDate, HashMap<String, Long> phoneNumbers) {
        super(name, birthDate, phoneNumbers);
    }
    public Owner(String name) {
        super(name);
    }
}

