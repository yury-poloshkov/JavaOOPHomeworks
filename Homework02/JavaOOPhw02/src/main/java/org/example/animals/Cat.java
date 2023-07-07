package org.example.animals;

import java.util.Arrays;

public class Cat extends Animal{

    public Cat(String color, String species, Integer legsCount) {
        super(color, species, legsCount);
        //TODO Auto-generated constructor stub
    }
    private void findFood() {
        System.out.println("Cat found food ");
    }
    private void findFood(int ... args) {
        System.out.println("Cat found food, count = " + Arrays.toString(args));
    }
    private void wakeUp() {
        System.out.println("Cat woke up ");
    }
    private void sleep() {
        System.out.println("Cat sleeps ");
    }
    private void eat() {
        System.out.println("Cat ate ");
    }
    public void hunt(int ... args) {
        wakeUp();
        findFood(args);
        eat();
        sleep();
    }
}
