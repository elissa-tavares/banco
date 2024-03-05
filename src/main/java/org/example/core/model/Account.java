/**
 * This class represents a bank account. It holds information about the account number, account balance,
 * and the person associated with the account (account holder).
 */
package org.example.core.model;

import java.math.BigDecimal;

public class Account {

    /**
     * The unique identifier for this account.
     */
    private Integer accountNumber;

    /**
     * The current balance of the account represented as a BigDecimal object for precise monetary calculations.
     */
    private BigDecimal accountBalance;

    /**
     * The person associated with this account (account holder).
     */
    private Person holder;

    @Override
    public String toString() {
        return "Account{" +
                "accountNumber=" + accountNumber +
                ", accountBalance=" + accountBalance +
                ", holder=" + holder +
                '}';
    }

    /**
     * Constructor for the Account class. Initializes a new account with a zero balance and associates it with the provided Person object (holder).
     *
     * @param holder The Person object representing the account holder.
     */
    public Account(Person holder) {
        this.accountBalance = BigDecimal.valueOf(0);
        this.holder = holder;
    }

    /**
     * Retrieves the account number.
     *
     * @return The account number as an Integer.
     */
    public Integer getAccountNumber() {
        return accountNumber;
    }

    /**
     * Sets the account number.
     *
     * @param accountNumber The new account number as an Integer.
     */
    public void setAccountNumber(Integer accountNumber) {
        this.accountNumber = accountNumber;
    }

    /**
     * Retrieves the current account balance.
     *
     * @return The account balance as a BigDecimal object.
     */
    public BigDecimal getAccountBalance() {
        return accountBalance;
    }

    /**
     * Sets the account balance.
     *
     * @param accountBalance The new account balance as a BigDecimal object.
     */
    public void setAccountBalance(BigDecimal accountBalance) {
        this.accountBalance = accountBalance;
    }

    /**
     * Retrieves the Person object associated with this account (account holder).
     *
     * @return The Person object representing the account holder.
     */
    public Person getHolder() {
        return holder;
    }

    /**
     * Sets the Person object associated with this account (account holder).
     *
     * @param holder The new Person object representing the account holder.
     */
    public void setHolder(Person holder) {
        this.holder = holder;
    }
}
