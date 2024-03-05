package org.example.core.model;

import java.math.BigDecimal;

public class Account {
    private Integer accountNumber;
    private BigDecimal accountBalance;
    private Person holder;

    @Override
    public String toString() {
        return "Account{" +
                "accountNumber=" + accountNumber +
                ", accountBalance=" + accountBalance +
                ", holder=" + holder +
                '}';
    }

    public Account(Person holder) {
        this.accountBalance = BigDecimal.valueOf(0);
        this.holder = holder;
    }

    public Integer getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Integer accountNumber) {
        this.accountNumber = accountNumber;
    }


    public BigDecimal getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(BigDecimal accountBalance) {
        this.accountBalance = accountBalance;
    }

    public Person getHolder() {
        return holder;
    }

    public void setHolder(Person holder) {
        this.holder = holder;
    }
}
