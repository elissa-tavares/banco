/**
 * This class implements a basic in-memory data store specifically for Person objects, following the CRUDPerson interface (Create, Read, Update, Delete) operations pattern.
 */
package org.example.infra.data.base;

import org.example.core.model.Person;
import org.example.infra.data.CRUD.CRUDPerson;

import java.util.ArrayList;
import java.util.List;

/**
 * In-memory data store for Person objects using a List collection.
 */
public class PersonList implements CRUDPerson<Person> {

    /**
     * Internal list used to store Person objects.
     */
    private final List<Person> list = new ArrayList<>();

    /**
     * Singleton instance of PersonList to ensure a single point of access.
     */
    private static PersonList instance;

    /**
     * Private constructor to enforce singleton pattern.
     */
    private PersonList() {
    }

    /**
     * Retrieves the singleton instance of PersonList.
     *
     * @return The singleton instance of PersonList.
     */
    public static PersonList getInstance() {
        // Lazy initialization: create the instance if it doesn't exist yet
        if (instance == null) {
            instance = new PersonList();
        }
        return instance;
    }

    /**
     * Creates a new Person object and adds it to the internal list.
     *
     * @param person The Person object to be created.
     */
    @Override
    public void create(Person person) {
        list.add(person);
    }

    /**
     * Updates an existing Person object in the internal list.
     *
     * @param newPerson The Person object containing the updated information.
     * @param person    The Person object to be updated (target object).
     */
    @Override
    public void update(Person newPerson, Person person) {
        person.setName(newPerson.getName());
        person.setSurname(newPerson.getSurname());
    }

    /**
     * Deletes a Person object from the internal list.
     *
     * @param person The Person object to be deleted.
     */
    @Override
    public void delete(Person person) {
        list.remove(person);
    }

    /**
     * Retrieves and returns a copy of the entire list containing all Person objects.
     *
     * @return A copy of the internal list containing all Person objects.
     */
    @Override
    public List<Person> findAll() {
        return new ArrayList<>(list); // Return a copy to avoid unintended modifications
    }
}
