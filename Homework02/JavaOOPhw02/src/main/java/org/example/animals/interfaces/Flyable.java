package org.example.animals.interfaces;

public interface Flyable {
    default float fly(float speed, float time, float height, String direction) {
        System.out.printf("Flied %s for %.2f km in %.2f hours at %.2f m height.\n",
                direction, speed * time, time, height);
        return speed;
    }
}
