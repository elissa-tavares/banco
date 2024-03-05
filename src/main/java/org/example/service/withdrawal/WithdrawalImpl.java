package org.example.service.withdrawal;

import org.example.core.model.Account;
import org.example.gateway.AccountRepositoryGateway;
import org.example.security.api.ExistingAccount;

import java.math.BigDecimal;

public class WithdrawalImpl implements WithdrawalServiceClient {
    private final AccountRepositoryGateway accountRepositoryGateway;
    private final ExistingAccount<Integer> existingAccountByNumber;

    public WithdrawalImpl(AccountRepositoryGateway accountRepositoryGateway, ExistingAccount<Integer> existingAccount) {
        this.accountRepositoryGateway = accountRepositoryGateway;
        this.existingAccountByNumber = existingAccount;
    }


    @Override
    public boolean execute(BigDecimal value, Integer accountNumber) {
        boolean existing = existingAccountByNumber.existing(accountNumber);
        Account account = accountRepositoryGateway.read(accountNumber);

        if (account.getAccountBalance().compareTo(value) < 0 || !existing) { //se o valor recebido for maior que o saldo da conta
            return false;
        } else {
            BigDecimal finalBalance = account.getAccountBalance().subtract(value);
            account.setAccountBalance(finalBalance);
            System.out.println(account);
            return true;
        }
    }
}
