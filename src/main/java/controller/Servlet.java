package controller;

import model.dao.UserDAO;
import model.entity.NotUniqueFieldException;
import model.entity.NoteBook;
import model.entity.Role;
import model.entity.User;
import model.util.UserValidator;
import org.mindrot.jbcrypt.BCrypt;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class Servlet extends HttpServlet {

//    "D:\\Own\\regform\\src\\main\\resources\\regex_container.properties"
    private static UserValidator userValidator = UserValidator.getInstance();
    private static NoteBook noteBook = new NoteBook();

    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Inside doGet");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
//        session.setAttribute("invalidData",null);

        System.out.println("Inside doPost");
        boolean isUserInputCorrect = true;
        System.out.println(req.getContextPath());
        User user = getUserFromRequest(req);
        System.out.println(user.toString());

        if (!userValidator.isValid(user)) {
            //askUserToCorrectInput();
            isUserInputCorrect = false;
            session.setAttribute("invalidData", userValidator.getInvalidData());
            session.removeAttribute("notUniqueData");
            resp.sendRedirect("index.jsp");
//            System.out.println(userValidator.getInvalidData());

        }
        else {
            session.removeAttribute("invalidData");
            try {
                noteBook.tryToAddUser(user);
            } catch (NotUniqueFieldException e) {
                isUserInputCorrect = false;
                System.out.println(e.getMessage());
                if (!(e.getNotUniqueData().getLogin() == null)) {
                    System.out.println(e.getNotUniqueData().getLogin());
                }
                if (!(e.getNotUniqueData().getEmail() == null)) {
                    System.out.println(e.getNotUniqueData().getEmail());
                }
                session.setAttribute("notUniqueData", e.getNotUniqueData());
                resp.sendRedirect("index.jsp");
            }
        }

        if(isUserInputCorrect){
            session.removeAttribute("notUniqueData");
            System.out.println("Trying to add user in DB");
            UserDAO userDAO = new UserDAO();
            userDAO.addUser(user);
            req.setAttribute("usersList",  userDAO.getAllUsers());
            req.getRequestDispatcher("users.jsp").forward(req, resp);
        }
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

        String hash = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
        System.out.println(hash);
        System.out.println("Hash length is " + hash.length());
        return user;
    }


}
