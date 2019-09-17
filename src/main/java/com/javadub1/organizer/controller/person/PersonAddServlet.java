package com.javadub1.organizer.controller.person;

import com.javadub1.organizer.model.Person;
import com.javadub1.organizer.service.PersonService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/persons/add")
public class PersonAddServlet extends HttpServlet {

    private final PersonService personService;

    public PersonAddServlet() {
        this.personService = new PersonService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.getRequestDispatcher("/persons-add.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        Person person = new Person();
        person.setFirstName(req.getParameter("first_name"));
        person.setLastName(req.getParameter("last_name"));
        person.setAge(Integer.parseInt(req.getParameter("age")));
        person.setPhoneNumber(req.getParameter("phone_number"));

        personService.savePersonToDatabase(person);

        resp.sendRedirect("/persons");

    }
}
