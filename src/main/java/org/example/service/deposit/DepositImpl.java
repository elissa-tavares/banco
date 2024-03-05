package org.example.service.deposit;

import org.example.core.model.Account;
import org.example.gateway.AccountRepositoryGateway;
import org.example.security.api.ExistingAccount;

import java.math.BigDecimal;

public class DepositImpl implements DepositServiceClient {
    private final AccountRepositoryGateway accountRepositoryGateway;
    private final ExistingAccount<Integer> existingAccountByNumber;

    public DepositImpl(AccountRepositoryGateway accountRepositoryGateway, ExistingAccount<Integer> existingAccount) {
        this.accountRepositoryGateway = accountRepositoryGateway;
        this.existingAccountByNumber = existingAccount;
    }

    @Override
    public boolean execute(BigDecimal value, Integer accountNumber) {
        boolean existing = existingAccountByNumber.existing(accountNumber);

        if (value.compareTo(BigDecimal.ZERO) <= 0 || !existing) { //se o valor recebido for menor que 0
            return false;
        } else {
            Account account = accountRepositoryGateway.read(accountNumber);
            BigDecimal finalBalance = account.getAccountBalance().add(value);
            account.setAccountBalance(finalBalance);
            //System.out.println(account);
            return true;
        }
    }
}
