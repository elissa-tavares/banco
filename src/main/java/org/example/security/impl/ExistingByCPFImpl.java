/**
 * This class implements the `ExistingAccount` interface for checking account existence
 * based on the account holder's CPF by delegating to the `AccountRepositoryGateway`.
 */
package org.example.security.impl;

import org.example.gateway.AccountRepositoryGateway;
import org.example.security.api.ExistingAccount;

public class ExistingByCPFImpl implements ExistingAccount<String> {

    /**
     * Reference to the `AccountRepositoryGateway` for interacting with account data.
     */
    private final AccountRepositoryGateway accountRepositoryGateway;

    /**
     * Constructor for ExistingByCPFImpl.
     *
     * @param accountRepositoryGateway An instance of `AccountRepositoryGateway` for account data access.
     */
    public ExistingByCPFImpl(AccountRepositoryGateway accountRepositoryGateway) {
        this.accountRepositoryGateway = accountRepositoryGateway;
    }

    /**
     * Checks if an account exists in the data store where the account holder's CPF matches the provided value.
     * Delegates the existence check to the `existingByCPF` method of the injected `AccountRepositoryGateway`.
     *
     * @param keyValue The CPF number (key value) to check for existence.
     * @return True if an account with a matching CPF is found, false otherwise.
     */
    @Override
    public boolean existing(String keyValue) {
        return accountRepositoryGateway.existingByCPF(keyValue);
    }
}