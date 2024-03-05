/**
 * This interface defines a contract for repositories that extend CRUD operations,
 * providing additional methods for checking the existence of objects based on different criteria.
 *
 * @param <T> The type of objects managed by this repository.
 */
package org.example.infra.repository;

import org.example.infra.data.CRUD.CRUD;

public interface Repository<T> extends CRUD<T> {

    /**
     * Checks if an object with the provided key (typically an identifier) exists in the data store.
     *
     * @param key The key to check for existence.
     * @return True if an object with the provided key exists, false otherwise.
     */
    boolean existingByNUmber(Integer key);

    /**
     * Checks if an object exists in the data store where a specific property (named CPF in this context)
     * matches the provided value.
     *
     * @param key The value to match against a specific property of the objects.
     * @return True if an object with a matching property value is found, false otherwise.
     */
    boolean existingByCPF(String key);
}
