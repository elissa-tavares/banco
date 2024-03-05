package org.example.gateway;

import org.example.core.model.Account;
import org.example.infra.database.Crud;

public interface AccountRepositoryGateway extends Crud {
    void create(Account account);

    boolean existingAccount(Long accountNumber);

    Account read(Long accountNumber);

    void delete(Account account);
}
