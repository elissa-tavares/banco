package org.example.infra.repository;

import org.example.core.model.Account;
import org.example.gateway.AccountRepositoryGateway;
import org.example.infra.database.Crud;


public class AccountRepositoryImpl implements AccountRepositoryGateway {

    private final Crud accountList;

    public AccountRepositoryImpl(Crud accountList) {
        this.accountList = accountList;
    }


    @Override
    public void create(Account account){
        accountList.create(account);
    }

    @Override
    public boolean existingAccount(Long accountNumber){
        return read(accountNumber) != null;

    }

    @Override
    public Account read(Long accountNumber) {
        return accountList.read(accountNumber);
    }

    @Override
    public void delete(Account account) {

    }

}
