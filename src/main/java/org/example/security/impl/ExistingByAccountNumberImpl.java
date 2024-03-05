/**
 * This class implements the `ExistingAccount` interface for checking account existence
 * based on account number (id) by delegating to the `AccountRepositoryGateway`.
 */
package org.example.security.impl;

import org.example.gateway.AccountRepositoryGateway;
import org.example.security.api.ExistingAccount;

public class ExistingByAccountNumberImpl implements ExistingAccount<Integer> {

    /**
     * Reference to the `AccountRepositoryGateway` for interacting with account data.
     */
    private final AccountRepositoryGateway accountRepositoryGateway;

    /**
     * Constructor for ExistingByAccountNumberImpl.
     *
     * @param accountRepositoryGateway An instance of `AccountRepositoryGateway` for account data access.
     */
    public ExistingByAccountNumberImpl(AccountRepositoryGateway accountRepositoryGateway) {
        this.accountRepositoryGateway = accountRepositoryGateway;
    }

    /**
     * Checks if an account exists in the data store based on the provided account number (id).
     * Delegates the existence check to the `existingByNUmber` method of the injected `AccountRepositoryGateway`.
     *
     * @param id The account number (id) to check for existence.
     * @return True if an account with the provided id exists, false otherwise.
     */
    @Override
    public boolean existing(Integer id) {
        return accountRepositoryGateway.existingByNUmber(id);
    }
}