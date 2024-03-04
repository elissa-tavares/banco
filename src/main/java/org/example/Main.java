package org.example;

import org.example.controller.AccountController;
import org.example.controller.AccountControllerImpl;
import org.example.infra.database.AccountList;
import org.example.infra.repository.AccountRepository;
import org.example.infra.repository.AccountRepositoryImpl;
import org.example.service.deposit.Deposit;
import org.example.service.deposit.DepositImpl;
import org.example.service.open_an_account.OpenAnAccount;
import org.example.service.open_an_account.OpenAnAccountImpl;
import org.example.service.withdrawal.Withdrawal;
import org.example.service.withdrawal.WithdrawalImpl;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        AccountRepository accountRepository = new AccountRepositoryImpl(AccountList.getInstance());
        Deposit deposit = new DepositImpl(accountRepository);
        OpenAnAccount openAnAccount = new OpenAnAccountImpl(accountRepository);
        Withdrawal withdrawal = new WithdrawalImpl(accountRepository);
        Scanner scanner = new Scanner(System.in);
        AccountController accountController = new AccountControllerImpl(deposit, openAnAccount, withdrawal, scanner);

        accountController.openAnAccount();
        accountController.deposit();
        accountController.withdrawal();
    }
}