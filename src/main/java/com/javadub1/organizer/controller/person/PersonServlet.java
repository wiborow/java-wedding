package com.javadub1.organizer.controller.person;

import com.javadub1.organizer.service.PersonService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/persons")
public class PersonServlet extends HttpServlet {

    private final PersonService personService;

    public PersonServlet() {
        this.personService = new PersonService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setAttribute("personList", personService.getAllPersons());
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/persons.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String operationMode = req.getParameter("operationMode");
        if("EDIT".equals(operationMode)){
            req.getRequestDispatcher("/persons/edit").forward(req, resp);
            return;
            //operacje dotyczace edytowania obiektu
        } else if("DELETE".equals(operationMode)){
            req.getRequestDispatcher("/persons/delete").forward(req, resp);
            return;
            //operacje dotyczace usuwania obiektu
        }
        resp.sendRedirect("/persons");
    }
}