/**
 * This class implements the `DepositServiceClient` interface, providing a service for depositing funds
 * into an account.
 */
package org.example.service.deposit;

import org.example.core.model.Account;
import org.example.gateway.AccountRepositoryGateway;
import org.example.security.api.ExistingAccount;

import java.math.BigDecimal;

public class DepositImpl implements DepositServiceClient {

    /**
     * Reference to the `AccountRepositoryGateway` for interacting with account data.
     */
    private final AccountRepositoryGateway accountRepositoryGateway;

    /**
     * Reference to an implementation of `ExistingAccount` for checking account existence by number.
     */
    private final ExistingAccount<Integer> existingAccountByNumber;

    /**
     * Constructor for DepositImpl.
     *
     * @param accountRepositoryGateway An instance of `AccountRepositoryGateway` for account data access.
     * @param existingAccount         An instance of `ExistingAccount` for account existence check.
     */
    public DepositImpl(AccountRepositoryGateway accountRepositoryGateway, ExistingAccount<Integer> existingAccount) {
        this.accountRepositoryGateway = accountRepositoryGateway;
        this.existingAccountByNumber = existingAccount;
    }

    /**
     * Executes a deposit operation on an account identified by the provided account number.
     *
     * @param value          The amount of money to be deposited (BigDecimal).
     * @param accountNumber  The account number where the deposit should be made.
     * @return True if the deposit is successful, false otherwise.
     */
    @Override
    public boolean execute(BigDecimal value, Integer accountNumber) {
        // Check if the deposit value is positive and the account exists
        boolean existing = existingAccountByNumber.existing(accountNumber);
        if (value.compareTo(BigDecimal.ZERO) <= 0 || !existing) {
            return false; // Deposit cannot be made with non-positive value or non-existent account
        }

        // Retrieve the account from the data store
        Account account = accountRepositoryGateway.read(accountNumber);

        // Update account balance and persist the changes
        BigDecimal finalBalance = account.getAccountBalance().add(value);
        account.setAccountBalance(finalBalance);
        // Optional: System.out.println(account); // For debugging or logging purposes

        return true; // Deposit successful
    }
}

