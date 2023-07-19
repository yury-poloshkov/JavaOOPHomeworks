package homework.repository.model;

import homework.repository.Persister;

public class User{
    private final String name;

    public User(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void save(){
        Persister persister = new Persister(this);
        persister.save();
    }
}
