package org.example.animals.interfaces;

public interface Swimable {

    default float swim(float speed, float time, float depth, String direction) {
        System.out.printf("Swam %s for %.2f km in %.2f hours at %.2f m depth.\n",
                direction, speed * time, time, depth);
        return speed;
    }
}
