package homework;

import homework.core.Reporter;
import homework.core.impl.ConsoleReporter;
import homework.repository.Persister;
import homework.repository.model.User;

public class Main{
    public static void main(String[] args){

        User user = new User("Bob");
        Reporter userConsoleReport = new ConsoleReporter(user);
        Persister userPersister = new Persister(user);
        userConsoleReport.report();
        userPersister.save();
    }
}