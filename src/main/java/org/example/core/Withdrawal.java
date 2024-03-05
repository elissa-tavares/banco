/**
 * This interface defines the contract for performing a withdrawal operation on a bank account.
 * Classes that implement this interface are responsible for carrying out the withdrawal logic.
 */
package org.example.core;

import java.math.BigDecimal;

public interface Withdrawal {

    /**
     * Executes a withdrawal operation, subtracting the specified value from the balance of the designated account.
     *
     * @param value        The amount of money to withdraw, represented as a BigDecimal object for precise calculations.
     * @param accountNumber The account number of the account from which to withdraw funds.
     * @return True if the withdrawal was successful, false otherwise.
     */
    boolean execute(BigDecimal value, Integer accountNumber);
}
