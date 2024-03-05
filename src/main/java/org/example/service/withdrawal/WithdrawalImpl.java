/**
 * This class implements the `WithdrawalServiceClient` interface, providing a service for withdrawing funds
 * from an account.
 */
package org.example.service.withdrawal;

import org.example.core.model.Account;
import org.example.gateway.AccountRepositoryGateway;
import org.example.security.api.ExistingAccount;

import java.math.BigDecimal;

public class WithdrawalImpl implements WithdrawalServiceClient {

    /**
     * Reference to the `AccountRepositoryGateway` for interacting with account data.
     */
    private final AccountRepositoryGateway accountRepositoryGateway;

    /**
     * Reference to an implementation of `ExistingAccount` for checking account existence by number.
     */
    private final ExistingAccount<Integer> existingAccountByNumber;

    /**
     * Constructor for WithdrawalImpl.
     *
     * @param accountRepositoryGateway An instance of `AccountRepositoryGateway` for account data access.
     * @param existingAccount         An instance of `ExistingAccount` for account existence check.
     */
    public WithdrawalImpl(AccountRepositoryGateway accountRepositoryGateway, ExistingAccount<Integer> existingAccount) {
        this.accountRepositoryGateway = accountRepositoryGateway;
        this.existingAccountByNumber = existingAccount;
    }

    /**
     * Executes a withdrawal operation on an account identified by the provided account number.
     *
     * @param value          The amount of money to be withdrawn (BigDecimal).
     * @param accountNumber  The account number from which the withdrawal should be made.
     * @return True if the withdrawal is successful, false otherwise.
     */
    @Override
    public boolean execute(BigDecimal value, Integer accountNumber) {
        // Check if the account exists and has sufficient balance
        boolean existing = existingAccountByNumber.existing(accountNumber);
        Account account = accountRepositoryGateway.read(accountNumber);
        if (account == null || account.getAccountBalance().compareTo(value) < 0 || !existing) {
            return false; // Withdrawal fails if account doesn't exist, has insufficient balance, or check fails
        }

        // Update account balance and persist the changes
        BigDecimal finalBalance = account.getAccountBalance().subtract(value);
        account.setAccountBalance(finalBalance);
        // Optional: System.out.println(account); // For debugging or logging purposes

        return true; // Withdrawal successful
    }
}

