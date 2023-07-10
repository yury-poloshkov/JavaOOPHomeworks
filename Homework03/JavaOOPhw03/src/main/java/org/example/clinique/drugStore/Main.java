package org.example.clinique.drugStore;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Pharmacy pharmacy1 = new Pharmacy();
        Component comp1 = new Component("Penicillin", "10 mg", 10);
        Component comp2 = new Component("Spirit", "100 g", 1000);
        pharmacy1.addComponent(comp1).addComponent(comp2);
        Pharmacy pharmacy4 = new Pharmacy();
        pharmacy4.addComponent(comp1).addComponent(comp2);

        Pharmacy pharmacy2 = new Pharmacy();
        Component comp3 = new Component("Penicillin", "10 mg", 3);
        Component comp40 = new Component("Spirit", "100 g", 13);
        Component comp41 = new Component("Spirit", "100 g", 13);
        pharmacy2.addComponent(comp3).addComponent(comp40);
        Pharmacy pharmacy5 = new Pharmacy();
        pharmacy5.addComponent(comp3).addComponent(comp41);

        Pharmacy pharmacy3 = new Pharmacy();
        Component comp5 = new Component("Penicillin", "10 mg", 12);
        Component comp6 = new Component("Spirit", "100 g", 100);
        pharmacy3.addComponent(comp5).addComponent(comp6);
        Pharmacy pharmacy6 = new Pharmacy();
        Component comp8 = new Component("Penicillin", "10 mg", 12);
        Component comp7 = new Component("Spirit", "100 g", 100);
        pharmacy6.addComponent(comp7).addComponent(comp8);

        // Задача 1: Сделать так, чтобы после добавления нескольких одинаковых объектов Pharmacy,
        // в сете result были только уникальные.

        Set<Pharmacy> result = new HashSet<>();
        result.add(pharmacy1);
        result.add(pharmacy2);
        result.add(pharmacy3);
        result.add(pharmacy4);
        result.add(pharmacy5);
        result.add(pharmacy6);

        System.out.println("Количество уникальных препаратов: " + result.size());
        System.out.println(result);
        System.out.println("--------------------------------------");

        // Задача 2: Переписать compareTo так, чтобы если power лекарств равны,
        // сравнение шло еще и по названиям компонентов лекарства.
        Component comp9 = new Component("Water", "100 mg", 12);
        Pharmacy pharmacy7 = new Pharmacy();
        pharmacy7.addComponent(comp9).addComponent(comp6);
        System.out.println(pharmacy6 + pharmacy3.toString() + " Результат сравнения: " + pharmacy6.compareTo(pharmacy3));
        System.out.println(pharmacy6 + pharmacy7.toString() + " Результат сравнения: " + pharmacy6.compareTo(pharmacy7));
    }
}
