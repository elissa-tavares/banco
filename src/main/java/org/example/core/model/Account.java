package org.example.core.model;

import java.math.BigDecimal;

public class Account {
    private Long accountNumber;
    private BigDecimal accountBalance;

    @Override
    public String toString() {
        return "Account{" +
                "accountNumber=" + accountNumber +
                ", accountBalance=" + accountBalance +
                '}';
    }

    public Account(Long accountNumber) {
        this.accountBalance = BigDecimal.valueOf(0);
    }

    public Long getAccountNumber(){
        return accountNumber;
    }

    public Account setAccountNumber(Long accountNumber){
        this.accountNumber = accountNumber;
        return this;
    }

    public BigDecimal getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(BigDecimal accountBalance) {
        this.accountBalance = accountBalance;
    }
}
