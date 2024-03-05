package org.example.service.open.account;

import org.example.core.model.Account;
import org.example.core.model.Person;
import org.example.gateway.AccountRepositoryGateway;
import org.example.gateway.OpenAccountImplGateway;

public class OpenAccountImpl implements OpenAccountImplGateway {
    private final AccountRepositoryGateway accountRepositoryGateway;

    public OpenAccountImpl(AccountRepositoryGateway accountRepository) {
        this.accountRepositoryGateway = accountRepository;
    }


    @Override
    public boolean execute(Person holder) {
        Account account = new Account(holder);
        accountRepositoryGateway.create(account);
        System.out.println(account);
        return true;
    }
}
