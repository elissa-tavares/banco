package org.example;

import org.example.controller.api.Controller;
import org.example.controller.api.OperationResult;
import org.example.controller.impl.DepositControllerImpl;
import org.example.controller.impl.OpenAccountControllerImpl;
import org.example.controller.impl.OperationResultImpl;
import org.example.controller.impl.WithdrawalControllerImpl;
import org.example.gateway.AccountRepositoryGateway;
import org.example.impl.deposit.DepositImpl;
import org.example.impl.open.account.OpenAccountImpl;
import org.example.impl.withdrawal.WithdrawalImpl;
import org.example.core.deposit.Deposit;
import org.example.core.open_an_account.OpenAnAccount;
import org.example.core.withdrawal.Withdrawal;
import org.example.infra.database.AccountList;
import org.example.infra.repository.AccountRepositoryImpl;
import org.example.validations.account.Existing;
import org.example.validations.account.existing.ExistingByNumberImpl;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        AccountRepositoryGateway accountRepositoryGateway = new AccountRepositoryImpl(AccountList.getInstance());

        Deposit deposit = new DepositImpl(accountRepositoryGateway);
        OpenAnAccount openAnAccount = new OpenAccountImpl(accountRepositoryGateway);
        Withdrawal withdrawal = new WithdrawalImpl(accountRepositoryGateway);
        Existing<Long> existingAccountByNumber = new ExistingByNumberImpl(accountRepositoryGateway);
        OperationResult operationResult = new OperationResultImpl();
        Scanner scanner = new Scanner(System.in);
        Controller depositController = new DepositControllerImpl(deposit, existingAccountByNumber, operationResult, scanner);
        Controller openAccountController = new OpenAccountControllerImpl(openAnAccount, existingAccountByNumber, operationResult, scanner);
        Controller withdrawalController = new WithdrawalControllerImpl(withdrawal, existingAccountByNumber, operationResult, scanner);

        openAccountController.execute();
        depositController.execute();
        withdrawalController.execute();

    }
}