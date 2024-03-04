package org.example.infra.database;

import org.example.core.model.Account;

public interface Crud {
    void create(Account account);
    Account read(Long accountNumber);
    void delete(Account account);
}
