package org.example.security.impl;

import org.example.gateway.AccountRepositoryGateway;
import org.example.security.api.ExistingAccount;

public class ExistingByAccountNumberImpl implements ExistingAccount<Integer> {
    private final AccountRepositoryGateway accountRepositoryGateway;

    public ExistingByAccountNumberImpl(AccountRepositoryGateway accountRepositoryGateway) {
        this.accountRepositoryGateway = accountRepositoryGateway;
    }

    @Override
    public boolean existing(Integer id){
        return accountRepositoryGateway.existingByNUmber(id);
    }
}
