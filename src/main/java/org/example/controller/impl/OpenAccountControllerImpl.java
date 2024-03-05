package org.example.controller.impl;

import org.example.controller.api.OpenAccountController;
import org.example.core.open_an_account.OpenAnAccount;
import org.example.messages.AccountMessage;
import org.example.messages.InputMessage;
import org.example.validations.dto.account_number.ExistingAccount;

import java.util.Scanner;

public class OpenAccountControllerImpl implements OpenAccountController {

    private final OpenAnAccount openAnAccount;
    private final ExistingAccount existingAccount;
    private final Scanner scanner;

    public OpenAccountControllerImpl(OpenAnAccount openAccount, ExistingAccount existingAccount, Scanner scanner) {
        this.openAnAccount = openAccount;
        this.existingAccount = existingAccount;
        this.scanner = scanner;
    }

    @Override
    public void openAnAccount() {
        Long accountNumber = inputAccountNumber();
        boolean openAccount = existingAccount.existingAccount(accountNumber);

        if (openAccount) {
            AccountMessage.ACCOUNT_ALREADY_EXISTS.print();
        } else {
            boolean successfully = openAnAccount.execute(accountNumber);
            printOperationResult(successfully, AccountMessage.ACCOUNT_OPEN_SUCCESS, AccountMessage.ACCOUNT_OPEN_FAILURE);
        }

    }

    private Long inputAccountNumber() {
        InputMessage.ENTER_ACCOUNT_NUMBER.print();
        return scanner.nextLong();
    }

    private void printOperationResult(boolean success, AccountMessage successMessage, AccountMessage failureMessage) {
        printMessage(success ? successMessage : failureMessage);
    }

    private void printMessage(AccountMessage message) {
        message.print();
    }
}
