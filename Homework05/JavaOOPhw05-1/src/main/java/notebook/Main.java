package notebook;

import notebook.controller.UserController;
import notebook.model.User;
import notebook.model.DBConnector;
import notebook.model.repository.GBRepository;
import notebook.model.repository.impl.UserRepository;
import notebook.view.UserView;

public class Main {
    public static void main(String[] args) {
        String dbPath = "data.txt";
        GBRepository<User, Long> repository = new UserRepository(new DBConnector(dbPath));
        UserController controller = new UserController(repository);
        UserView view = new UserView(controller);
        view.run();
    }
}
