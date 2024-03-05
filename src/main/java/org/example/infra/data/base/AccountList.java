/**
 * This class implements a basic in-memory data store specifically for Account objects, following the CRUD (Create, Read, Update, Delete) operations pattern.
 */
package org.example.infra.data.base;

import org.example.core.model.Account;
import org.example.infra.data.CRUD.CRUD;

import java.util.ArrayList;
import java.util.List;

/**
 * In-memory data store for Account objects using a List collection.
 */
public class AccountList implements CRUD<Account> {

    /**
     * Internal list used to store Account objects.
     */
    private final List<Account> list = new ArrayList<>();

    /**
     * Singleton instance of AccountList to ensure a single point of access.
     */
    private static AccountList instance;

    /**
     * Private constructor to enforce singleton pattern.
     */
    private AccountList() {
    }

    /**
     * Retrieves the singleton instance of AccountList.
     *
     * @return The singleton instance of AccountList.
     */
    public static AccountList getInstance() {
        // Lazy initialization: create the instance if it doesn't exist yet
        if (instance == null) {
            instance = new AccountList();
        }
        return instance;
    }

    /**
     * Creates a new Account object, assigns a unique account number based on the current list size,
     * prints the account information to the console, and adds it to the internal list.
     *
     * @param account The Account object to be created.
     */
    @Override
    public void create(Account account) {
        account.setAccountNumber(list.size() + 1);
        System.out.println(account);
        list.add(account);
    }

    /**
     * Reads and retrieves an Account object from the internal list based on the provided account number (id).
     * Utilizes streams for potentially more concise filtering.
     *
     * @param id The account number (id) to identify the target Account object.
     * @return The Account object matching the provided id, or null if not found.
     */
    @Override
    public Account read(Integer id) {
        return list.stream()
                .filter(account -> account.getAccountNumber().equals(id))
                .findFirst()
                .orElse(null);
    }

    /**
     * Not currently implemented for this in-memory data store.
     * May require additional logic for persistence or synchronization in a production environment.
     *
     * @param newAccount The new Account object to be used for update.
     * @param key        The Account object to be used as the update target (placeholder for now).
     */
    @Override
    public void update(Account newAccount, Account key) {

    }

    /**
     * Removes an Account object from the internal list.
     *
     * @param account The Account object to be deleted.
     */
    @Override
    public void delete(Account account) {
        list.remove(account);
    }

    /**
     * Retrieves and returns a copy of the entire list containing all Account objects.
     *
     * @return A copy of the internal list containing all Account objects.
     */
    @Override
    public List<Account> findAll() {
        return new ArrayList<>(list); // Return a copy to avoid unintended modifications
    }
}
