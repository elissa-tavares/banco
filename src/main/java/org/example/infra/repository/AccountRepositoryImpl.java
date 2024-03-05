package org.example.infra.repository;

import org.example.core.model.Account;
import org.example.core.model.Person;
import org.example.gateway.AccountRepositoryGateway;
import org.example.infra.database.api.CRUD.CRUD;
import org.example.infra.database.api.CRUD.CRUDPerson;

import java.util.List;


public class AccountRepositoryImpl implements AccountRepositoryGateway {

    private final CRUD<Account> accountList;
    private final CRUDPerson<Person> personList;

    public AccountRepositoryImpl(CRUD<Account> accountList, CRUDPerson<Person> personList) {
        this.accountList = accountList;
        this.personList = personList;
    }

    @Override
    public void create(Account account) {
        accountList.create(account);
        personList.create(account.getHolder());
    }

    @Override
    public Account read(Integer id) {
        return accountList.read(id);
    }

    @Override
    public void update(Account newAccount, Account key) {

    }

    @Override
    public void delete(Account account) {
        accountList.delete(account);
        personList.delete(account.getHolder());
    }

    @Override
    public List<Account> findAll() {
        return accountList.findAll();
    }

    @Override
    public boolean existingByNUmber(Integer key) {
        return read(key) != null;
    }

    @Override
    public boolean existingByCPF(String CPF) {
        List<Account> accountList = findAll();
        return accountList.stream()
                .anyMatch(account -> account.getHolder().getCpf().equals(CPF));
    }

}
