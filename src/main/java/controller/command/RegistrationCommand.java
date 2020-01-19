package controller.command;

import model.entity.NoteBook;
import model.util.UserValidator;

public class RegistrationCommand implements Command {
    private static UserValidator userValidator = UserValidator.getInstance();
    private static NoteBook noteBook = new NoteBook();

    @Override
    public String execute() {

        return null;
    }
}
