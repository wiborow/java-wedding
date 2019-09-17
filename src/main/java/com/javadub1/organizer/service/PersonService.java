package com.javadub1.organizer.service;

import com.javadub1.organizer.database.EntityDao;
import com.javadub1.organizer.model.Person;

        import java.util.List;

        public class PersonService {

            private final EntityDao entityDao;

            public PersonService() {
                entityDao = new EntityDao();
            }

            public void addPersonToDatabase(Person personToAdd){
                entityDao.saveOrUpdate(personToAdd);
            }

            public List<Person> getAllPersons(){
                return entityDao.list(Person.class);
            }

            public void deletePerson(Long id){
                Person entityToDelete = entityDao.getById(Person.class, id);
                entityDao.delete(entityToDelete);
            }


        }