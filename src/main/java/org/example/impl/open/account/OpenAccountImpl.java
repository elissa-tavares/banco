package org.example.impl.open.account;

import org.example.core.model.Account;
import org.example.gateway.AccountRepositoryGateway;
import org.example.gateway.OpenAccountImplGateway;

public class OpenAccountImpl implements OpenAccountImplGateway {
    private final AccountRepositoryGateway accountRepositoryGateway;

    public OpenAccountImpl(AccountRepositoryGateway accountRepository) {
        this.accountRepositoryGateway = accountRepository;
    }


    @Override
    public boolean execute(Long accountNumber) {
            Account account = new Account(accountNumber);
            account.setAccountNumber(accountNumber);
            accountRepositoryGateway.create(account);
            //System.out.println(account);
            return true;
    }
}
