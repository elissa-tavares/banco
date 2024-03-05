package org.example.validations.dto.account_number;

import org.example.gateway.AccountRepositoryGateway;

public class ExistingAccountImpl implements ExistingAccount {
    private final AccountRepositoryGateway accountRepositoryGateway;

    public ExistingAccountImpl(AccountRepositoryGateway accountRepositoryGateway) {
        this.accountRepositoryGateway = accountRepositoryGateway;
    }
    public boolean existingAccount(Long accountNumber){
        return accountRepositoryGateway.existingAccount(accountNumber);
    }
}
