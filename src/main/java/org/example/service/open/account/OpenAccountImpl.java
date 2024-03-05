/**
 * This class implements the `OpenAccountServiceClient` interface, providing a service
 * for opening new accounts.
 */
package org.example.service.open.account;

import org.example.core.model.Account;
import org.example.core.model.Person;
import org.example.gateway.AccountRepositoryGateway;
import org.example.security.api.ExistingAccount;

public class OpenAccountImpl implements OpenAccountServiceClient {

    /**
     * Reference to the `AccountRepositoryGateway` for interacting with account data.
     */
    private final AccountRepositoryGateway accountRepositoryGateway;

    /**
     * Reference to an implementation of `ExistingAccount` for checking account existence by CPF.
     */
    private final ExistingAccount<String> existingAccountByCPF;

    /**
     * Constructor for OpenAccountImpl.
     *
     * @param accountRepository      An instance of `AccountRepositoryGateway` for account data access.
     * @param existingAccount        An instance of `ExistingAccount` for account existence check by CPF.
     */
    public OpenAccountImpl(AccountRepositoryGateway accountRepository, ExistingAccount<String> existingAccount) {
        this.accountRepositoryGateway = accountRepository;
        this.existingAccountByCPF = existingAccount;
    }

    /**
     * Executes the account opening process for a given account holder.
     *
     * @param holder The Person object representing the account holder.
     * @return True if the account is successfully opened, false otherwise.
     */
    @Override
    public boolean execute(Person holder) {
        // Check for existing accounts with the same holder's CPF
        boolean existing = existingAccountByCPF.existing(holder.getCpf());
        if (existing) {
            return false; // Account opening fails if a matching CPF is found
        }

        // Create a new Account object and persist it
        Account account = new Account(holder);
        accountRepositoryGateway.create(account);
        // Optional: System.out.println(account); // For debugging or logging purposes

        return true; // Account opened successfully
    }
}
