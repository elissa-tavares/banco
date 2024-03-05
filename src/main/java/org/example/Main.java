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
import org.example.infra.database.base.AccountList;
import org.example.infra.database.base.PersonList;
import org.example.infra.repository.AccountRepositoryImpl;
import org.example.security.api.ExistingAccount;
import org.example.security.impl.ExistingByAccountNumberImpl;
import org.example.security.impl.ExistingByCPFImpl;
import org.example.service.deposit.DepositImpl;
import org.example.service.open.account.OpenAccountImpl;
import org.example.service.withdrawal.WithdrawalImpl;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        AccountRepositoryGateway accountRepositoryGateway = new AccountRepositoryImpl(AccountList.getInstance(), PersonList.getInstance());

        DepositImplGateway deposit = new DepositImpl(accountRepositoryGateway);
        OpenAccountImplGateway openAnAccount = new OpenAccountImpl(accountRepositoryGateway);
        WithdrawalImplGateway withdrawal = new WithdrawalImpl(accountRepositoryGateway);

        ExistingAccount<Integer> existingAccountByNumber = new ExistingByAccountNumberImpl(accountRepositoryGateway);
        ExistingAccount<String> existingAccountByCPF = new ExistingByCPFImpl(accountRepositoryGateway);
        OperationResult operationResult = new OperationResultImpl();
        Scanner scanner = new Scanner(System.in);

        Controller depositController = new DepositControllerImpl(deposit, existingAccountByNumber, operationResult, scanner);
        Controller openAccountController = new OpenAccountControllerImpl(openAnAccount, existingAccountByCPF, operationResult, scanner);
        Controller withdrawalController = new WithdrawalControllerImpl(withdrawal, existingAccountByNumber, operationResult, scanner);

        openAccountController.execute();
        depositController.execute();
        withdrawalController.execute();
    }
}