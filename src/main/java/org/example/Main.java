package org.example;

import org.example.service.deposit.DepositServiceClient;
import org.example.service.open.account.OpenAccountServiceClient;
import org.example.service.withdrawal.WithdrawalServiceClient;
import org.example.service.deposit.DepositImpl;
import org.example.service.open.account.OpenAccountImpl;
import org.example.service.withdrawal.WithdrawalImpl;
import org.example.gateway.AccountRepositoryGateway;
import org.example.infra.controller.api.Controller;
import org.example.infra.controller.api.OperationResult;
import org.example.infra.controller.impl.DepositControllerImpl;
import org.example.infra.controller.impl.OpenAccountControllerImpl;
import org.example.infra.controller.impl.OperationResultImpl;
import org.example.infra.controller.impl.WithdrawalControllerImpl;
import org.example.infra.data.base.AccountList;
import org.example.infra.data.base.PersonList;
import org.example.infra.repository.AccountRepositoryImpl;
import org.example.security.api.ExistingAccount;
import org.example.security.impl.ExistingByAccountNumberImpl;
import org.example.security.impl.ExistingByCPFImpl;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        AccountRepositoryGateway accountRepositoryGateway = new AccountRepositoryImpl(AccountList.getInstance(), PersonList.getInstance());
        ExistingAccount<Integer> existingAccountByNumber = new ExistingByAccountNumberImpl(accountRepositoryGateway);
        ExistingAccount<String> existingAccountByCPF = new ExistingByCPFImpl(accountRepositoryGateway);

        DepositServiceClient depositServiceClient = new DepositImpl(accountRepositoryGateway, existingAccountByNumber);
        OpenAccountServiceClient openAnAccountServiceClient = new OpenAccountImpl(accountRepositoryGateway, existingAccountByCPF);
        WithdrawalServiceClient withdrawalServiceClient = new WithdrawalImpl(accountRepositoryGateway, existingAccountByNumber);

        OperationResult operationResult = new OperationResultImpl();
        Scanner scanner = new Scanner(System.in);

        Controller depositController = new DepositControllerImpl(depositServiceClient, operationResult, scanner);
        Controller openAccountController = new OpenAccountControllerImpl(openAnAccountServiceClient, operationResult, scanner);
        Controller withdrawalController = new WithdrawalControllerImpl(withdrawalServiceClient, operationResult, scanner);

        openAccountController.execute();
        depositController.execute();
        withdrawalController.execute();
    }
}