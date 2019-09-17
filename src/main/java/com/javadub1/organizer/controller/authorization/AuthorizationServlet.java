package com.javadub1.organizer.controller.authorization;

import com.javadub1.organizer.service.AuthorizationService;
import com.javadub1.organizer.model.authorization.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Objects;

@WebServlet("/login")
public class AuthorizationServlet extends HttpServlet {

    private final AuthorizationService authorizationService;

    public AuthorizationServlet() {
        authorizationService = new AuthorizationService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("userName");
        String password = req.getParameter("password");

        User user = authorizationService.findUser(userName, password);
        if(Objects.nonNull(user)){
            HttpSession session = req.getSession(true);
            session.setMaxInactiveInterval(5*60);
            session.setAttribute("user", user);
        }
        resp.sendRedirect("/persons");
    }
}

