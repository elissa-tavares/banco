/**
 * This interface defines the contract for performing a deposit operation on a bank account.
 * Classes that implement this interface are responsible for carrying out the deposit logic.
 */
package org.example.core;

import java.math.BigDecimal;

public interface Deposit {

    /**
     * Executes a deposit operation, adding the specified value to the balance of the designated account.
     *
     * @param value        The amount of money to deposit, represented as a BigDecimal object for precise calculations.
     * @param accountNumber The account number of the account to receive the deposit.
     * @return True if the deposit was successful, false otherwise.
     */
    boolean execute(BigDecimal value, Integer accountNumber);
}
