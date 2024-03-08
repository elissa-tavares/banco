/**
 * This class implements the `AccountRepositoryGateway` interface, providing functionalities
 * to interact with Account and Person data through underlying CRUD data stores.
 */
package org.example.infra.repository;

import org.example.core.model.Account;
import org.example.core.model.Person;
import org.example.adapters.gateway.AccountRepositoryGateway;
import org.example.infra.data.CRUD.CRUD;
import org.example.infra.data.CRUD.CRUDPerson;

import java.util.List;

public class AccountRepositoryImpl implements AccountRepositoryGateway {

    /**
     * Reference to the CRUD implementation used for Account data access.
     */
    private final CRUD<Account> accountList;

    /**
     * Reference to the CRUDPerson implementation used for Person data access (account holder).
     */
    private final CRUDPerson<Person> personList;

    /**
     * Constructor for AccountRepositoryImpl.
     *
     * @param accountList  An instance of CRUD for Account data access.
     * @param personList   An instance of CRUDPerson for Person data access (account holder).
     */
    public AccountRepositoryImpl(CRUD<Account> accountList, CRUDPerson<Person> personList) {
        this.accountList = accountList;
        this.personList = personList;
    }

    /**
     * Creates a new Account object, persists it using the underlying CRUD implementation,
     * and creates the associated Person object (account holder) in the Person data store.
     *
     * @param account The Account object to be created.
     */
    @Override
    public void create(Account account) {
        accountList.create(account);
        personList.create(account.getHolder());
    }

    /**
     * Reads and retrieves an Account object from the underlying data store based on its account number (id).
     * Utilizes the CRUD read operation.
     *
     * @param id The account number (id) to identify the target Account object.
     * @return The Account object matching the provided id, or null if not found.
     */
    @Override
    public Account read(Integer id) {
        return accountList.read(id);
    }

    /**
     * Not currently implemented for this repository.
     * May require additional logic for update operations in a production environment.
     *
     * @param newAccount The new Account object to be used for update.
     * @param key        The Account object to be used as the update target (placeholder for now).
     */
    @Override
    public void update(Account newAccount, Account key) {

    }

    /**
     * Deletes an Account object from the underlying data store and its associated Person object
     * (account holder) from the Person data store using their respective CRUD implementations.
     *
     * @param account The Account object to be deleted.
     */
    @Override
    public void delete(Account account) {
        accountList.delete(account);
        personList.delete(account.getHolder());
    }

    /**
     * Retrieves a list of all Account objects using the underlying CRUD findAll operation.
     *
     * @return A list of all Account objects.
     */
    @Override
    public List<Account> findAll() {
        return accountList.findAll();
    }

    /**
     * Checks if an Account with the provided account number (id) exists in the data store
     * by delegating to the read operation and checking for null.
     *
     * @param key The account number (id) to check for existence.
     * @return True if an Account with the provided id exists, false otherwise.
     */
    @Override
    public boolean existingByNUmber(Integer key) {
        return read(key) != null;
    }

/**
 * Checks if an Account exists in the data store where the account holder's CPF matches the provided value.
 * Utilizes streams for potentially concise filtering based on CPF equality.
 *
 * @param CPF The CPF number of the potential account holder.
 * @return True if an
*/

 @Override
    public boolean existingByCPF(String CPF) {
        List<Account> accountList = findAll();
        return accountList.stream()
                .anyMatch(account -> account.getHolder().getCpf().equals(CPF));
    }

}
