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

    public Person getPersonById(Long id){
        return entityDao.getById(Person.class, id);
    }

    public void savePersonToDatabase(Person person) {
        entityDao.saveOrUpdate(person);
    }

    public void deletePerson(Long personId) {
        entityDao.deleteById(Person.class, personId);
    }
}