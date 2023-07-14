package ru.gb.lessons.interfaces;

import ru.gb.lessons.interfaces.core.clients.home.impl.Cat;
import ru.gb.lessons.interfaces.core.clients.owners.Owner;
import ru.gb.lessons.interfaces.core.clients.wild.impl.WildCat;
import ru.gb.lessons.interfaces.core.repositorium.FileRepository;

import java.time.LocalDate;

/**
 Небольшая шпаргалка по синтаксису java:

 1) Названия классов в java - существительные с большой буквы верблюжьей нотацией: CamelCase;
 2) названия методов - отглагольные, с маленькой буквы, верблюжьей нотацией: getUserById;
 3) Названия переменных - существительные с маленькой буквы, верблюжьей нотацией: maxCount;
 4) названия пакетов в java существительные, всегда с маленькой буквы и в одно слово;
 -! Если логика классов внутри пакета не позволяет назвать все в одно существительное, надо вложить один пакет в другой.
 */
public class Main {
    public static void main(String[] args) throws ClassNotFoundException {
        FileRepository database = new FileRepository();

        WildCat wildCat =
                new WildCat(
                        1, 4, LocalDate.of(2023, 1, 5), new Owner("incognito"));
        database.createNewRecord(wildCat);

        Cat homeCat =
                new Cat(2, "Tom", 4, LocalDate.of(2022, 4,13), new Owner("Ivanov Ivan"));
        database.createNewRecord(homeCat);

        Cat homeCat2 =
                new Cat(3, "Jerry", 4, LocalDate.of(2022, 4,13), new Owner("Ivanov Ivan"));
        database.createNewRecord(homeCat2);

        Cat homeCat3 =
                new Cat(4, "Mikka", 4, LocalDate.of(2022, 4,13), new Owner("Ivanov Ivan"));
        database.createNewRecord(homeCat3);

        System.out.println(database.findRecord(new Cat(), 3));
        System.out.println(database.findRecord(new WildCat(), 3));
        database.removeRecord(new Cat(), 3);

        database.updateRecord(new Cat(), 4);
        System.out.println(database.findRecord(new Cat(), 4));
    }
}
