package org.example.service.withdrawal;

import org.example.core.model.Account;
import org.example.infra.repository.AccountRepository;

import java.math.BigDecimal;

public class WithdrawalImpl implements Withdrawal {
    private final AccountRepository accountRepository;

    public WithdrawalImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public boolean execute(BigDecimal value, Long accountNumber) {
        Account account = accountRepository.read(accountNumber);

        if (account == null || account.getAccountBalance().compareTo(value) <= 0) { //se o valor recebido for maior que o saldo da conta
            return false;
        } else {
            BigDecimal finalBalance = account.getAccountBalance().subtract(value);
            account.setAccountBalance(finalBalance);
//            System.out.println(account.getAccountBalance());
            return true;
        }
    }
}
