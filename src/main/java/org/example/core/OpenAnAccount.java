/**
 * This interface defines the contract for opening a new bank account.
 * Classes that implement this interface are responsible for carrying out the account creation logic.
 */
package org.example.core;

import org.example.core.model.Person;

public interface OpenAnAccount {

    /**
     * Executes the logic to open a new account for the provided Person object (account holder).
     *
     * @param holder The Person object representing the individual who will own the new account.
     * @return True if the account is opened successfully, false otherwise.
     */
    boolean execute(Person holder);
}
