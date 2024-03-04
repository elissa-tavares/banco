package org.example.service.deposit;

import org.example.core.model.Account;
import org.example.infra.repository.AccountRepository;

import java.math.BigDecimal;

public class DepositImpl implements Deposit{
    private final AccountRepository accountRepository;

    public DepositImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public boolean execute(BigDecimal value, Long accountNumber) {
        Account account = accountRepository.read(accountNumber);

        if(account == null || value.compareTo(BigDecimal.ZERO) <= 0 ){ //se o valor recebido for menor que 0
            return false;
        } else {
            BigDecimal finalBalance = account.getAccountBalance().add(value);
            account.setAccountBalance(finalBalance);
//            System.out.println(account.getAccountBalance());
//            System.out.println(account);
            return true;
        }
    }
}