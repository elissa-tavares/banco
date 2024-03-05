package org.example.validations.dto.account_number;

import org.example.infra.repository.AccountRepository;
import org.example.validations.dto.account_number.ExistingAccount;

public class ExistingAccountImpl implements ExistingAccount {
    private final AccountRepository accountRepository;

    public ExistingAccountImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }
    public boolean existingAccount(Long accountNumber){
        return accountRepository.existingAccount(accountNumber);
    }
}
