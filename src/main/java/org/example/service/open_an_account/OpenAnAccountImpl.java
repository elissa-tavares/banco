package org.example.service.open_an_account;

import org.example.core.model.Account;
import org.example.infra.repository.AccountRepository;

public class OpenAnAccountImpl implements OpenAnAccount {
    private final AccountRepository accountRepository;

    public OpenAnAccountImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public boolean execute(Long accountNumber) {
        boolean notExistingAccount = accountRepository.validAccountNumber(accountNumber);

        if (notExistingAccount) {
            Account account = new Account(accountNumber);
            account.setAccountNumber(accountNumber);
            accountRepository.create(account);
            //System.out.println(account);
            return true;
        } else {
            return false;
        }
    }
}
