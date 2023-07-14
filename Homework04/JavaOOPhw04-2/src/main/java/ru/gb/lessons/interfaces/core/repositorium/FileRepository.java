package ru.gb.lessons.interfaces.core.repositorium;

import ru.gb.lessons.interfaces.core.clients.Animal;
import ru.gb.lessons.interfaces.core.clients.owners.Owner;

import java.io.*;
import java.time.LocalDate;
import java.util.*;

import static java.lang.System.*;


public class FileRepository {
    //final String PATH = "/data/";
    private List<String> readDB(Animal animal) {
        String path = animal.getClassName()+".txt";
        List<String> fileContent = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(path))){
            String line = reader.readLine();
            while (line != null) {
                fileContent.add(line);
                line = reader.readLine();
            }
        } catch (FileNotFoundException e) {
            File file = new File(path);
            try {
                file.createNewFile();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return fileContent;
    }
    private void writeDB(Animal animal, List<String> database) {
        String path = animal.getClassName()+".txt";
        try(FileWriter writer = new FileWriter(path, false)) {
            // запись всей строки
            for (String line: database) {
                writer.write(line+"\n");
            }
        } catch(IOException ex) {
            out.println(ex.getMessage());
        }
    }
    public void createNewRecord(Animal animal) {
        List<String> database = readDB(animal);
        if (!database.contains(animal.toString())){
            database.add(animal.toString());
            writeDB(animal, database);
        }
    }
    public String findRecord(Animal animal, int id){
        List<String> database = readDB(animal);
        for (String line: database) {
            if (line.contains("id=" + id + ",")) {
                return line;
            }
        }
        return null;
    }
    public void removeRecord(Animal animal, int id){
        List<String> database = readDB(animal);
        for (int i = database.size() - 1; i >= 0; i--) {
            if (database.get(i).contains("id=" + id + ",")) {
                database.remove(i);
                }
        writeDB(animal, database);
        }
    }
    public void updateRecord(Animal animal, int id){
        List<String> database = readDB(animal);
        for (String line: database) {
            if (line.contains("id=" + id + ",")) {
                animal.setId(id);
                animal.setName(input("Имя: "
                        + line.substring(line.indexOf("name")+6,line.indexOf("',"))
                        + ". Введите новое имя: "));
                animal.setNumberOfLimbs(Integer.parseInt(input("Количество конечностей: "
                        + line.substring(line.indexOf("numberOfLimbs") + 14,line.indexOf("numberOfLimbs") + 15)
                        + ". Введите обновленные данные: ")));
                animal.setRegistrationDate(LocalDate.now());
                animal.setOwner(new Owner(input("Имя владельца: "
                        + line.substring(line.indexOf("owner")+6,line.indexOf("record")-2)
                        + ". Введите новое имя: ")));
                //animal.setRecords(Arrays.asList(line.substring(line.indexOf("["),line.indexOf("]"))));
                database.set(database.indexOf(line), animal.toString());
                writeDB(animal, database);
            }
        }
    }
    private String input(String prompt){
        Scanner scn = new Scanner(System.in);
        out.print(prompt);
        return scn.nextLine();
    }
}
