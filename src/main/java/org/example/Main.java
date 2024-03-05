package org.example;

import org.example.gateway.DepositImplGateway;
import org.example.gateway.OpenAccountImplGateway;
import org.example.gateway.WithdrawalImplGateway;
import org.example.gateway.AccountRepositoryGateway;
import org.example.infra.controller.api.Controller;
import org.example.infra.controller.api.OperationResult;
import org.example.infra.controller.impl.DepositControllerImpl;
import org.example.infra.controller.impl.OpenAccountControllerImpl;
import org.example.infra.controller.impl.OperationResultImpl;
import org.example.infra.controller.impl.WithdrawalControllerImpl;
import org.example.infra.database.AccountList;
import org.example.infra.repository.AccountRepositoryImpl;
import org.example.infra.validations.account.Existing;
import org.example.infra.validations.account.existing.ExistingByNumberImpl;
import org.example.impl.deposit.DepositImpl;
import org.example.impl.open.account.OpenAccountImpl;
import org.example.impl.withdrawal.WithdrawalImpl;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        AccountRepositoryGateway accountRepositoryGateway = new AccountRepositoryImpl(AccountList.getInstance());

        DepositImplGateway deposit = new DepositImpl(accountRepositoryGateway);
        OpenAccountImplGateway openAnAccount = new OpenAccountImpl(accountRepositoryGateway);
        WithdrawalImplGateway withdrawal = new WithdrawalImpl(accountRepositoryGateway);

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