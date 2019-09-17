package com.javadub1.organizer.service;

import com.javadub1.organizer.database.EntityDao;
import com.javadub1.organizer.model.Person;

        import java.util.List;

        public class PersonService {

            private final EntityDao entityDao;

            public PersonService() {
                entityDao = new EntityDao();
            }

            public List<Person> getAllPersons(){
                return entityDao.getAllEntityOfType(Person.class);
            }

        }