package com.javadub1.organizer.controller.person;

import com.javadub1.organizer.model.Person;
import com.javadub1.organizer.service.PersonService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/persons/edit")
public class PersonEditServlet extends HttpServlet {

    private final PersonService personService;

    public PersonEditServlet() {
        this.personService = new PersonService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        Long personIdForEdit = Long.valueOf(req.getParameter("person_id"));
        Person personToEdit = personService.getPersonById(personIdForEdit);
        req.setAttribute("personToEdit", personToEdit);
        req.getRequestDispatcher("/persons-edit.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String id = req.getParameter("person_id");
        System.out.println(req.getParameter("person_id"));
        String operationMode = req.getParameter("operationMode");
        if("EDIT".equals(operationMode)){
            resp.sendRedirect("/persons/edit?person_id=" + id);
            return;
        } else if("SAVE".equals(operationMode)){
            Person updatedPerson = new Person();
            updatedPerson.setId(Long.valueOf(req.getParameter("person_id")));
            updatedPerson.setFirstName(req.getParameter("first_name"));
            updatedPerson.setLastName(req.getParameter("last_name"));
            updatedPerson.setPhoneNumber(req.getParameter("phone_number"));
            updatedPerson.setAge(Integer.parseInt(req.getParameter("age")));

            personService.savePersonToDatabase(updatedPerson);
        }
        resp.sendRedirect("/persons");

    }
}