package controller.command;

import model.entity.NoteBook;
import model.entity.Role;
import model.entity.User;
import model.util.UserValidator;

import javax.servlet.http.HttpServletRequest;

public class RegistrationCommand implements Command {
    private static UserValidator userValidator = UserValidator.getInstance();
    private static NoteBook noteBook = new NoteBook();

    @Override
    public String execute() {

        return null;
    }

    private User getUserFromRequest(HttpServletRequest request) {
            User user = new User();
            user.setLogin(request.getParameter("login"));
            user.setRole(Role.valueOf(request.getParameter("role")));
            user.setNameUa(request.getParameter("nameUa"));
            user.setSurnameUa(request.getParameter("surNameUa"));
            user.setNameEng(request.getParameter("nameEng"));
            user.setSurnameEng(request.getParameter("surNameEng"));
            user.setEmail(request.getParameter("email"));
            user.setPassword(request.getParameter("password"));
            return user;
        }
}
