package org.example.infra.database;

import org.example.core.model.Account;

import java.util.ArrayList;
import java.util.List;

public class AccountList implements Crud {
    private List<Account> list = new ArrayList<>();

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
        list.add(account);
    }

    @Override
    public Account read(Long accountNumber) {
        return list.stream()
                .filter(account -> account.getAccountNumber().equals(accountNumber))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void delete(Account account) {
        list.remove(account);
    }
}
