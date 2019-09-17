package com.javadub1.organizer.controller.person;

import com.javadub1.organizer.model.Person;
import com.javadub1.organizer.service.PersonService;

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
                personService = new PersonService();
            }

            @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
                req.setAttribute("personList", personService.getAllPersons());
                req.getRequestDispatcher("/person.jsp").forward(req, resp);
            }

            @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

                        Person entityToSave = new Person();
                entityToSave.setFirstName(req.getParameter("first_name"));
                entityToSave.setLastName(req.getParameter("last_name"));
                entityToSave.setPhoneNumber(req.getParameter("phone_number"));
                entityToSave.setAge(Integer.parseInt(req.getParameter("age")));

                        personService.addPersonToDatabase(entityToSave);
                resp.sendRedirect("/persons");
            }

        }