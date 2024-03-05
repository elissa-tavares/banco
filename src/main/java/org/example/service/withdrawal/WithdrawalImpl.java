package org.example.service.withdrawal;

import org.example.core.model.Account;
import org.example.gateway.AccountRepositoryGateway;
import org.example.gateway.WithdrawalImplGateway;

import java.math.BigDecimal;

public class WithdrawalImpl implements WithdrawalImplGateway {
    private final AccountRepositoryGateway accountRepositoryGateway;

    public WithdrawalImpl(AccountRepositoryGateway accountRepositoryGateway) {
        this.accountRepositoryGateway = accountRepositoryGateway;
    }


    @Override
    public boolean execute(BigDecimal value, Integer accountNumber) {
        Account account = accountRepositoryGateway.read(accountNumber);

        if (account.getAccountBalance().compareTo(value) < 0) { //se o valor recebido for maior que o saldo da conta
            return false;
        } else {
            BigDecimal finalBalance = account.getAccountBalance().subtract(value);
            account.setAccountBalance(finalBalance);
            System.out.println(account);
            return true;
        }
    }
}
