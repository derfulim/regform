package controller;

import model.entity.Role;
import org.junit.Test;
import org.mockito.Mockito;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;

import static org.junit.Assert.*;

public class ServletTest extends Mockito {

    @Test
    public void doPost() {
        Servlet servlet = new Servlet();

        String path = "users.jsp";

        HttpServletRequest req = mock(HttpServletRequest.class);
        HttpServletResponse resp = mock(HttpServletResponse.class);
        RequestDispatcher requestDispatcher = mock(RequestDispatcher.class);
        HttpSession session = mock(HttpSession.class);

        try {

            when(req.getParameter("login")).thenReturn("derfulim0");
            when(req.getParameter("role")).thenReturn("SPEAKER");
            when(req.getParameter("nameUa")).thenReturn("Ярослав");
            when(req.getParameter("surNameUa")).thenReturn("Барашенко");
            when(req.getParameter("nameEng")).thenReturn("Yaroslav");
            when(req.getParameter("surNameEng")).thenReturn("Barashenko");
            when(req.getParameter("email")).thenReturn("barashenko@ukr.net");
            when(req.getParameter("password")).thenReturn("1111111");

            when(req.getRequestDispatcher(path)).thenReturn(requestDispatcher);
            when(req.getSession()).thenReturn(session);

            servlet.doPost(req,resp);
            verify(requestDispatcher).forward(req,resp);

        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}