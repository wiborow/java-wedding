package com.javadub1.organizer.controller;


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
                this.personService = new PersonService();
            }

            @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
                req.setAttribute("personList", personService.getAllPersons());
                req.getRequestDispatcher("/persons.jsp").forward(req, resp);
            }

            @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
                super.doPost(req, resp);
            }
}