package org.example.infra.controller.impl;

import org.example.gateway.OpenAccountImplGateway;
import org.example.infra.controller.api.Controller;
import org.example.infra.controller.api.OperationResult;
import org.example.infra.messages.AccountMessage;
import org.example.infra.messages.InputMessage;
import org.example.infra.validations.account.Existing;

import java.util.Scanner;

public class OpenAccountControllerImpl implements Controller {

    private final OpenAccountImplGateway openAnAccountGateway;
    private final Existing<Long> existingAccount;
    private final OperationResult operationResult;
    private final Scanner scanner;

    public OpenAccountControllerImpl(OpenAccountImplGateway openAccount, Existing<Long> existingAccount, OperationResult operationResult, Scanner scanner) {
        this.openAnAccountGateway = openAccount;
        this.existingAccount = existingAccount;
        this.operationResult = operationResult;
        this.scanner = scanner;
    }

    @Override
    public void execute() {
        Long accountNumber = inputAccountNumber();
        boolean openAccount = existingAccount.existing(accountNumber);

        if (openAccount) {
            AccountMessage.ACCOUNT_ALREADY_EXISTS.print();
        } else {
            boolean successfully = openAnAccountGateway.execute(accountNumber);
            operationResult.message(successfully, AccountMessage.ACCOUNT_OPEN_SUCCESS, AccountMessage.ACCOUNT_OPEN_FAILURE);
        }

    }

    private Long inputAccountNumber() {
        InputMessage.ENTER_ACCOUNT_NUMBER.print();
        return scanner.nextLong();
    }
}
