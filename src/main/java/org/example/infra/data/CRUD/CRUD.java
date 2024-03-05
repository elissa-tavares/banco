/**
 * This interface defines a contract for basic CRUD (Create, Read, Update, Delete) operations on a generic data type `T`.
 * Implementations of this interface can provide specific data access functionalities for different data sources.
 */
package org.example.infra.data.CRUD;

import java.util.List;

public interface CRUD<T> {

    /**
     * Creates a new object of type `T` and persists it in the underlying data store.
     *
     * @param o The object of type `T` to be created.
     */
    void create(T o);

    /**
     * Reads and retrieves an object of type `T` from the underlying data store based on the provided key (typically an identifier).
     *
     * @param key The key (identifier) used to locate the target object.
     * @return The object of type `T` matching the provided key, or null if not found.
     */
    T read(Integer key);

    /**
     * Updates an existing object of type `T` in the underlying data store.
     * The implementation might require both the new and existing object references.
     *
     * @param o   The new object of type `T` containing the updated information.
     * @param key The key (identifier) used to locate the object to be updated.
     */
    void update(T o, T key);

    /**
     * Deletes an object of type `T` from the underlying data store.
     *
     * @param o The object of type `T` to be deleted.
     */
    void delete(T o);

    /**
     * Retrieves and returns a list of all objects of type `T` stored in the underlying data store.
     *
     * @return A list of all objects of type `T`.
     */
    List<T> findAll();
}
