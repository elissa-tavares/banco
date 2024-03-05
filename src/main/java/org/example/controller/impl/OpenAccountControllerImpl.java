package org.example.controller.impl;

import org.example.controller.api.Controller;
import org.example.controller.api.OperationResult;
import org.example.core.open_an_account.OpenAnAccount;
import org.example.messages.AccountMessage;
import org.example.messages.InputMessage;
import org.example.validations.account.Existing;

import java.util.Scanner;

public class OpenAccountControllerImpl implements Controller {

    private final OpenAnAccount openAnAccount;
    private final Existing<Long> existingAccount;
    private final OperationResult operationResult;
    private final Scanner scanner;

    public OpenAccountControllerImpl(OpenAnAccount openAccount, Existing<Long> existingAccount, OperationResult operationResult, Scanner scanner) {
        this.openAnAccount = openAccount;
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
            boolean successfully = openAnAccount.execute(accountNumber);
            operationResult.message(successfully, AccountMessage.ACCOUNT_OPEN_SUCCESS, AccountMessage.ACCOUNT_OPEN_FAILURE);
        }

    }

    private Long inputAccountNumber() {
        InputMessage.ENTER_ACCOUNT_NUMBER.print();
        return scanner.nextLong();
    }
}
