package notebook.view;

import notebook.controller.UserController;
import notebook.model.User;
import notebook.controller.Commands;

import java.util.List;
import java.util.Scanner;

public class UserView {
    private final UserController userController;

    public UserView(UserController userController) {
        this.userController = userController;
    }

    public void run() {
        Commands com = Commands.NONE;
        while (com != Commands.EXIT) {
            showMenu();
            String command = prompt("Введите команду: ").toUpperCase();
            try {
                com = Commands.valueOf(command);
            } catch (Exception e) {
                System.out.println("Unsupported operation. Try again...");
                com = Commands.NONE;
                timeOut();
            }
            switch (com) {
                case CREATE -> {
                    System.out.println("----- Регистрация нового пользователя -----");
                    String firstName = prompt("Имя: ");
                    String lastName = prompt("Фамилия: ");
                    String phone = prompt("Номер телефона: ");
                    userController.createUser(new User(firstName, lastName, phone));
                }
                case READ -> {
                    System.out.println("----- Введите данные пользователя для поиска -----");
                    String id = prompt("Идентификатор пользователя: ");
                    try {
                        User user = userController.readUser(Long.parseLong(id));
                        if (user != null) {
                            System.out.println((user));
                        } else {
                            System.out.printf("Пользователь с идентификатором %s не найден.\n", id);
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid identificator");
                    }
                    timeOut();
                }
                case LIST -> {
                    try {
                        System.out.println("----- Список пользователей -----");
                        List<User> users = userController.readAllUsers();
                        for (User user : users) {
                            System.out.print(user);
                        }
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                    timeOut();
                }
                case UPDATE -> {
                    try {
                        System.out.println("----- Обновление данных пользователя -----");
                        System.out.println("(Нажмите ENTER, если не хотите менять поле)");
                        Long userid = Long.parseLong(prompt("Введите идентификатор пользователя: "));
                        User user = userController.readUser(userid);
                        if (user != null) {
                            String name = prompt("Имя: ");
                            name = (name.equals("") ? user.getFirstName() : name);
                            String secondName = prompt("Фамилия: ");
                            secondName = (secondName.equals("") ? user.getLastName() : secondName);
                            String number = prompt("Номер телефона: ");
                            number = (number.equals("") ? user.getPhone() : number);
                            User updated = new User(name, secondName, number);
                            userController.updateUser(userid, updated);
                        } else {
                            System.out.printf("Пользователь с идентификатором %s не найден.\n", userid);
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid identificator");
                        timeOut();
                    }catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }
                case DELETE -> {
                    try {
                        System.out.println("----- Удаление пользователя -----");
                        Long userid = Long.parseLong(prompt("Введите идентификатор пользователя: "));
                        userController.deleteUser(userid);
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid identificator");
                        timeOut();
                    }
                }
            }
            }
    }

    private void showMenu () {
        StringBuilder sb = new StringBuilder();
        sb.append("----- СПРАВОЧНИК ПОЛЬЗОВАТЕЛЕЙ v.2023.07.14 -----\n");
        sb.append("ГЛАВНОЕ МЕНЮ:\n");
        for (var item : Commands.values()) {
            if (item != Commands.NONE) {
                sb.append(" ").append(item).append("\n");
            }
        }
        sb.append("-----------------------------------------");
        System.out.print("\033[H\033[J");
        System.out.println(sb);
    }
    private String prompt(String message){
        Scanner in = new Scanner(System.in);
        System.out.print(message);
        return in.nextLine();
    }
    private void timeOut() {
        System.out.println("Press ENTER to continue");
        Scanner stopScn = new Scanner(System.in);
        stopScn.nextLine();
    }
}
