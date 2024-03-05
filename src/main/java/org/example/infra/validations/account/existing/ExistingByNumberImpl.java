package org.example.infra.validations.account.existing;

import org.example.gateway.AccountRepositoryGateway;
import org.example.infra.validations.account.Existing;

public class ExistingByNumberImpl implements Existing<Long> {
    private final AccountRepositoryGateway accountRepositoryGateway;

    public ExistingByNumberImpl(AccountRepositoryGateway accountRepositoryGateway) {
        this.accountRepositoryGateway = accountRepositoryGateway;
    }
    public boolean existing(Long accountNumber){
        return accountRepositoryGateway.existingAccount(accountNumber);
    }
}
