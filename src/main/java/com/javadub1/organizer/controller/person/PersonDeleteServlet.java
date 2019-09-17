package com.javadub1.organizer.controller.person;

import com.javadub1.organizer.service.PersonService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/persons/delete")
public class PersonDeleteServlet extends HttpServlet {

    private final PersonService personService;

    public PersonDeleteServlet() {
        this.personService = new PersonService();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long personId = Long.valueOf(req.getParameter("person_id"));
        personService.deletePerson(personId);
        resp.sendRedirect("/persons");
    }
}
