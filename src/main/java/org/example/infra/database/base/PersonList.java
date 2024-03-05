package org.example.infra.database.base;

import org.example.core.model.Person;
import org.example.infra.database.api.CRUD.CRUDPerson;

import java.util.ArrayList;
import java.util.List;

public class PersonList implements CRUDPerson<Person> {

    private final List<Person> list = new ArrayList<>();

    private static PersonList instance;

    private PersonList() {
    }

    public static PersonList getInstance() {
        // Lazy initialization: create the instance if it doesn't exist yet
        if (instance == null) {
            instance = new PersonList();
        }
        return instance;
    }

    @Override
    public void create(Person person) {
        list.add(person);
    }

    @Override
    public void update(Person newPerson, Person person) {
        person.setName(newPerson.getName());
        person.setSurname(newPerson.getSurname());
    }

    @Override
    public void delete(Person o) {
        list.remove(o);

    }

    @Override
    public List<Person> findAll() {
        return list;
    }
}
