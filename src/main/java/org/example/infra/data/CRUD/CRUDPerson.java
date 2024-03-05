/**
 * This interface defines a contract for basic CRUD (Create, Read, Update, Delete) operations specifically for Person objects.
 * Implementations of this interface can provide functionalities for managing Person data in different data stores.
 *
 * **Note:** While the type parameter `<T>` is present, it is not utilized in this specific interface.
 * Consider using a generic `CRUD` interface for broader data model support if needed.
 */
package org.example.infra.data.CRUD;

import java.util.List;

public interface CRUDPerson<T> {

        /**
         * Creates a new Person object and persists it in the underlying data store.
         *
         * @param o The Person object to be created.
         */
        void create(T o);

        /**
         * Updates an existing Person object in the underlying data store.
         *
         * @param newPerson The Person object containing the updated information.
         * @param person    The Person object to be updated (target object).
         */
        void update(T newPerson, T person);

        /**
         * Deletes a Person object from the underlying data store.
         *
         * @param o The Person object to be deleted.
         */
        void delete(T o);

        /**
         * Retrieves and returns a list of all Person objects stored in the underlying data store.
         *
         * @return A list of all Person objects.
         */
        List<T> findAll();
}
