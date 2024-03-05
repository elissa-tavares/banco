package org.example;

import org.example.controller.AccountController;
import org.example.controller.AccountControllerImpl;
import org.example.gateway.AccountRepositoryGateway;
import org.example.impl.deposit.DepositImpl;
import org.example.impl.open_an_account.OpenAnAccountImpl;
import org.example.impl.withdrawal.WithdrawalImpl;
import org.example.core.deposit.Deposit;
import org.example.core.open_an_account.OpenAnAccount;
import org.example.core.withdrawal.Withdrawal;
import org.example.infra.database.AccountList;
import org.example.infra.repository.AccountRepositoryImpl;
import org.example.validations.dto.account_number.ExistingAccount;
import org.example.validations.dto.account_number.ExistingAccountImpl;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        AccountRepositoryGateway accountRepositoryGateway = new AccountRepositoryImpl(AccountList.getInstance());

        Deposit deposit = new DepositImpl(accountRepositoryGateway);
        OpenAnAccount openAnAccount = new OpenAnAccountImpl(accountRepositoryGateway);
        Withdrawal withdrawal = new WithdrawalImpl(accountRepositoryGateway);
        ExistingAccount existingAccount = new ExistingAccountImpl(accountRepositoryGateway);
        Scanner scanner = new Scanner(System.in);
        AccountController accountController = new AccountControllerImpl(deposit, openAnAccount, withdrawal, existingAccount, scanner);

        accountController.openAnAccount();
        accountController.deposit();
        accountController.withdrawal();
    }
}