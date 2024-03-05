package org.example.security.impl;

import org.example.gateway.AccountRepositoryGateway;
import org.example.security.api.ExistingAccount;

public class ExistingByCPFImpl implements ExistingAccount<String> {

    private final AccountRepositoryGateway accountRepositoryGateway;

    public ExistingByCPFImpl(AccountRepositoryGateway accountRepositoryGateway) {
        this.accountRepositoryGateway = accountRepositoryGateway;
    }
    @Override
    public boolean existing(String keyValue) {
        return accountRepositoryGateway.existingByCPF(keyValue);
    }
}
