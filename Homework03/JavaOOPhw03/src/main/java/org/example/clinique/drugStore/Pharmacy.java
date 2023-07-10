package org.example.clinique.drugStore;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class Pharmacy implements Iterable<Component>, Comparable<Pharmacy> {
    private List<Component> components;
    private int componentsCount;

    public Pharmacy() {
        this.components = new ArrayList<>();
        this.componentsCount = 0;
    }
    public Pharmacy addComponent (Component component) {
        int pos = 0;
        if (!this.components.isEmpty()) {
            while (pos < components.size() && component.getName().compareTo(components.get(pos).getName()) > 0) {
                pos++;
            }
        }
        this.components.add(pos, component);
        this.componentsCount++;
        return this;
    }
    public List<Component> getComponents() {
        return components;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass() || this.getPower() != ((Pharmacy) o).getPower()) return false;
        Pharmacy that = (Pharmacy) o;
        return componentsCount == that.componentsCount && Objects.equals(components, that.components);
    }

    @Override
    public int hashCode() {
        return Objects.hash(components, componentsCount);
    }

    @Override
    public String toString() {
        return "Pharmacy{" +
                "components=" + components +
                ", index=" + componentsCount +
                '}' + ":total power = " + this.getPower()+"\n";
    }

    @Override
    public Iterator<Component> iterator() {
        return new ComponentIterator();
    }

    @Override
    public int compareTo(Pharmacy o) {
        int pow1 = this.getPower();
        int pow2 = o.getPower();
        int checkResult = Integer.compare(pow1, pow2);
        if (checkResult == 0 && !(this.equals(o))) {
            float pow3 = this.getPower()/this.getWeight();
            float pow4 = o.getPower()/o.getWeight();
            checkResult = Float.compare(pow3, pow4);
        }
        return checkResult;
    }

    private int getPower () {
        int result = 0;
        for (Component elem: this.getComponents()) {
            result += elem.getPower();
        }
        return result;
    }
    public float getWeight() {
        float result = 0;
        for (Component elem: this.getComponents()) {
            result += elem.getWeight();
        }
        return result;
    }

}
