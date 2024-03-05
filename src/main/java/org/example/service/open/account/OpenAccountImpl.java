package org.example.service.open.account;

import org.example.core.model.Account;
import org.example.core.model.Person;
import org.example.gateway.AccountRepositoryGateway;
import org.example.service.client.OpenAccountServiceClient;
import org.example.security.api.ExistingAccount;

public class OpenAccountImpl implements OpenAccountServiceClient {
    private final AccountRepositoryGateway accountRepositoryGateway;
    private final ExistingAccount<String> existingAccountByCPF;

    public OpenAccountImpl(AccountRepositoryGateway accountRepository, ExistingAccount<String> existingAccount) {
        this.accountRepositoryGateway = accountRepository;
        this.existingAccountByCPF = existingAccount;
    }


    @Override
    public boolean execute(Person holder) {
        boolean existing = existingAccountByCPF.existing(holder.getCpf());

        if (existing) {
            return false;
        }

        Account account = new Account(holder);
        accountRepositoryGateway.create(account);
        System.out.println(account);
        return true;
    }
}
