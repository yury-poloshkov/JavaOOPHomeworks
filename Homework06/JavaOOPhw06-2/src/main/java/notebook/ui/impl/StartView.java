package notebook.ui.impl;

import notebook.core.GBRepository;
import notebook.core.controller.NoteController;
import notebook.core.controller.UserController;
import notebook.core.impl.NoteRepository;
import notebook.core.impl.UserRepository;
import notebook.repository.DBConnector;
import notebook.repository.model.Note;
import notebook.repository.model.User;
import notebook.ui.View;

import static java.lang.Thread.sleep;

public class StartView implements View {
    @Override
    public void run() {
        String command = "";
        while (!command.equals("EXIT")) {
            showMenu("----- ЗАПИСНАЯ КНИЖКА v.2023.07.20 -----\n"
                    + "ГЛАВНОЕ МЕНЮ:\n");
            command = prompt("Введите команду: ").toUpperCase();
            switch (command) {
                case "LOGIN" -> {
                    System.out.println("----- Вход в личную записную книжку -----");
                    try {
                        Long userID = Long.parseLong(prompt("Введите иденификатор пользователя: "));
                        timeOut();
                        String dbPath = "notes.txt";
                        GBRepository<Note, Long> repository = new NoteRepository(new DBConnector(dbPath));
                        NoteController controller = new NoteController(repository);
                        NotebookView view = new NotebookView(controller, userID);
                        view.run();
                    } catch (Exception e) {
                        System.out.println("Access denied! Invalid user/password...");
                    }
                }
                case "USERS" -> {
                    String dbPath = "users.txt";
                    GBRepository<User, Long> repository = new UserRepository(new DBConnector(dbPath));
                    UserController controller = new UserController(repository);
                    UserView view = new UserView(controller);
                    view.run();
                }
                case "EXIT" -> {}
                default -> {
                    System.out.println("Unsupported operation. Try again...");
                    try {
                        sleep(1500);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }

    @Override
    public void showMenu(String header) {
        String sb = header +
                "  LOGIN\n" +
                "  USERS\n" +
                "-----------------------------------------\n" +
                "  EXIT\n" +
                "-----------------------------------------";
        System.out.print("\033[H\033[J");
        System.out.println(sb);
    }
}