package com.javadub1.organizer.controller.person;

import com.javadub1.organizer.service.PersonService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

        @WebServlet("/persons/crud")
public class PersonCrudServlet extends HttpServlet {

            private final PersonService personService;

            public PersonCrudServlet() {
                personService = new PersonService();
            }

            @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
                String actionType = req.getParameter("actionType");
                if ("delete".equals(actionType)) {
                        String id = req.getParameter("id");
                        personService.deletePerson(Long.valueOf(id));
                    } else if("update".equals(actionType)){
                        System.out.println("not implemented yet");
                    } else if("editableForId".equals(actionType)){
                        resp.sendRedirect("/persons?editable=" +  req.getParameter("id"));
                        return;
                    }
                resp.sendRedirect("/persons");

                    }
}
