/**
 * This interface defines a contract for security-related actions that require
 * checking the existence of an account based on a certain value.
 *
 * @param <T> The type of the key value used to determine account existence.
 */
package org.example.security.api;

public interface ExistingAccount<T> {

    /**
     * Checks if an account exists based on the provided key value.
     *
     * @param keyValue The key value to use for existence check.
     * @return True if an account exists with the given key value, false otherwise.
     */
    boolean existing(T keyValue);
}
