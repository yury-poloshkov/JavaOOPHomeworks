package org.example.clinique.drugStore;

import java.util.Objects;

public class Component {
    private String name;
    private String weight;
    private int power;

    public Component(String name, String weight, int power) {
        this.name = name;
        this.weight = weight;
        this.power = power;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Component component = (Component) o;
        return Objects.equals(name, component.name) && power/this.getWeight() == component.power/component.getWeight();
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, power/this.getWeight());
    }

    @Override
    public String toString() {
        return "Component{" +
                "name='" + name + '\'' +
                ", weight='" + weight + '\'' +
                ", power=" + power +
                '}';
    }

    public String getName() {
        return name;
    }

    public int getPower() {
        return this.power;
    }
    public float getWeight(){ // возвращает вес компонента в граммах
        if (this != null) {
            String[] s = this.weight.split(" ");
            switch (s[1]) {
                case "kg":
                    s[1] = "1000";
                    break;
                case "mg":
                    s[1] = "0.001";
                    break;
                case "mkg":
                    s[1] = "0.000001";
                    break;
                default:
                    s[1] = "1";
                    break;
            }
            return Float.parseFloat(s[0]) * Float.parseFloat(s[1]);
        }
        return 0;
    }
}
