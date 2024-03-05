package org.example.impl.withdrawal;

import org.example.core.model.Account;
import org.example.core.withdrawal.Withdrawal;
import org.example.gateway.AccountRepositoryGateway;

import java.math.BigDecimal;

public class WithdrawalImpl implements Withdrawal {
    private final AccountRepositoryGateway accountRepositoryGateway;

    public WithdrawalImpl(AccountRepositoryGateway accountRepositoryGateway) {
        this.accountRepositoryGateway = accountRepositoryGateway;
    }


    @Override
    public boolean execute(BigDecimal value, Long accountNumber) {
        Account account = accountRepositoryGateway.read(accountNumber);

        if (account.getAccountBalance().compareTo(value) < 0) { //se o valor recebido for maior que o saldo da conta
            return false;
        } else {
            BigDecimal finalBalance = account.getAccountBalance().subtract(value);
            account.setAccountBalance(finalBalance);
//            System.out.println(account.getAccountBalance());
            return true;
        }
    }
}
