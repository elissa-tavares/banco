package org.example;

import org.example.adapters.service.DepositServiceClient;
import org.example.adapters.service.OpenAccountServiceClient;
import org.example.adapters.service.WithdrawalServiceClient;
import org.example.impl.deposit.DepositUseCaseImpl;
import org.example.impl.open.OpenAccountUseCaseImpl;
import org.example.impl.withdrawal.WithdrawalUseCaseImpl;
import org.example.adapters.gateway.AccountRepositoryGateway;
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

/**
 * This class serves as the entry point for the application, demonstrating a layered architecture
 * for managing bank accounts.
 */
public class Main {

    public static void main(String[] args) {
        /**
         * Data Access Layer
         */
        AccountRepositoryGateway accountRepositoryGateway = new AccountRepositoryImpl(AccountList.getInstance(), PersonList.getInstance());

        /**
         * Security Layer
         */
        ExistingAccount<Integer> existingAccountByNumber = new ExistingByAccountNumberImpl(accountRepositoryGateway);
        ExistingAccount<String> existingAccountByCPF = new ExistingByCPFImpl(accountRepositoryGateway);

        /**
         * Service Layer
         */
        DepositServiceClient depositServiceClient = new DepositUseCaseImpl(accountRepositoryGateway, existingAccountByNumber);
        OpenAccountServiceClient openAnAccountServiceClient = new OpenAccountUseCaseImpl(accountRepositoryGateway, existingAccountByCPF);
        WithdrawalServiceClient withdrawalServiceClient = new WithdrawalUseCaseImpl(accountRepositoryGateway, existingAccountByNumber);

        /**
         * Additional Dependencies
         */
        OperationResult operationResult = new OperationResultImpl();
        Scanner scanner = new Scanner(System.in);

        /**
         * Controller Layer
         */
        Controller depositController = new DepositControllerImpl(depositServiceClient, operationResult, scanner);
        Controller openAccountController = new OpenAccountControllerImpl(openAnAccountServiceClient, operationResult, scanner);
        Controller withdrawalController = new WithdrawalControllerImpl(withdrawalServiceClient, operationResult, scanner);

        /**
         * Application Flow
         */
        openAccountController.execute();
        depositController.execute();
        withdrawalController.execute();
    }
}