package org.example.service.deposit;

import org.example.core.model.Account;
import org.example.gateway.AccountRepositoryGateway;
import org.example.gateway.DepositImplGateway;

import java.math.BigDecimal;

public class DepositImpl implements DepositImplGateway {
    private final AccountRepositoryGateway accountRepositoryGateway;

    public DepositImpl(AccountRepositoryGateway accountRepositoryGateway) {
        this.accountRepositoryGateway = accountRepositoryGateway;
    }

    @Override
    public boolean execute(BigDecimal value, Integer accountNumber) {
        Account account = accountRepositoryGateway.read(accountNumber);

        if (value.compareTo(BigDecimal.ZERO) <= 0) { //se o valor recebido for menor que 0
            return false;
        } else {
            BigDecimal finalBalance = account.getAccountBalance().add(value);
            account.setAccountBalance(finalBalance);
            //System.out.println(account);
            return true;
        }
    }
}
