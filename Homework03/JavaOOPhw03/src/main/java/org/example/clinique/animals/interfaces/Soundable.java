package org.example.clinique.animals.interfaces;

public interface Soundable {
    default float sound(float soundPower, float time){
        System.out.printf("Screamed for %.2f min with a force of %.2f dB.\n", time, soundPower);
        return soundPower * time;
    }
}
