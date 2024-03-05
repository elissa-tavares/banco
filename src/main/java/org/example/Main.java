package org.example;

import org.example.controller.api.DepositController;
import org.example.controller.api.OpenAccountController;
import org.example.controller.api.WithdrawalController;
import org.example.controller.impl.DepositControllerImpl;
import org.example.controller.impl.OpenAccountControllerImpl;
import org.example.controller.impl.WithdrawalControllerImpl;
import org.example.gateway.AccountRepositoryGateway;
import org.example.impl.deposit.DepositImpl;
import org.example.impl.open_account.OpenAccountImpl;
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
        OpenAnAccount openAnAccount = new OpenAccountImpl(accountRepositoryGateway);
        Withdrawal withdrawal = new WithdrawalImpl(accountRepositoryGateway);
        ExistingAccount existingAccount = new ExistingAccountImpl(accountRepositoryGateway);
        Scanner scanner = new Scanner(System.in);
        DepositController depositController = new DepositControllerImpl(deposit, existingAccount, scanner);
        OpenAccountController openAccountController = new OpenAccountControllerImpl(openAnAccount, existingAccount, scanner);
        WithdrawalController withdrawalController = new WithdrawalControllerImpl(withdrawal, existingAccount, scanner);

        openAccountController.openAnAccount();
        depositController.deposit();
        withdrawalController.withdrawal();

    }
}