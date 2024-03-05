package org.example.controller.impl;

import org.example.controller.api.DepositController;
import org.example.core.deposit.Deposit;
import org.example.messages.AccountMessage;
import org.example.messages.InputMessage;
import org.example.validations.dto.account_number.ExistingAccount;

import java.math.BigDecimal;
import java.util.Scanner;

public class DepositControllerImpl implements DepositController {

    private final Deposit deposit;
    private final ExistingAccount existingAccount;
    private final Scanner scanner;

    public DepositControllerImpl(Deposit deposit, ExistingAccount existingAccount, Scanner scanner) {
        this.deposit = deposit;
        this.existingAccount = existingAccount;
        this.scanner = scanner;
    }


    @Override
    public void deposit() {
        Long accountNumber = inputAccountNumber();
        boolean existing = existingAccount.existingAccount(accountNumber);

        if (existing) {
            BigDecimal value = inputValue();
            boolean successfully = deposit.execute(value, accountNumber);
            printOperationResult(successfully, AccountMessage.DEPOSIT_SUCCESS, AccountMessage.DEPOSIT_FAILURE);
        } else {
            AccountMessage.ACCOUNT_NOT_EXIST.print();
        }
    }

    private BigDecimal inputValue() {
        InputMessage.ENTER_VALUE.print();
        return scanner.nextBigDecimal();
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
