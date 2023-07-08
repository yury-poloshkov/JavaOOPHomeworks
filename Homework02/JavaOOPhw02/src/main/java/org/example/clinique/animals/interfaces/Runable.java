package org.example.clinique.animals.interfaces;

public interface Runable {
    default float run(float speed, float time, String direction) {
        System.out.printf("Went %s for %.2f km in %.2f hours.\n",
                direction, speed * time, time);
        return speed * time;
    }
}
