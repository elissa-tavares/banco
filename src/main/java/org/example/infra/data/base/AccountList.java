package org.example.infra.data.base;

import org.example.core.model.Account;
import org.example.infra.data.CRUD.CRUD;

import java.util.ArrayList;
import java.util.List;

public class AccountList implements CRUD<Account> {
    private final List<Account> list = new ArrayList<>();

    private static AccountList instance;

    private AccountList() {
    }

    public static AccountList getInstance() {
        // Lazy initialization: create the instance if it doesn't exist yet
        if (instance == null) {
            instance = new AccountList();
        }
        return instance;
    }

    @Override
    public void create(Account account) {
        account.setAccountNumber(list.size() + 1);
        System.out.println(account);
        list.add(account);
    }

    @Override
    public Account read(Integer id) {
        return list.stream()
                .filter(account -> account.getAccountNumber().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void update(Account newAccount, Account key) {

    }

    @Override
    public void delete(Account account) {
        list.remove(account);
    }

    @Override
    public List<Account> findAll() {
        return list;
    }
}
